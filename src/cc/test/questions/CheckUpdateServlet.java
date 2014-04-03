package cc.test.questions;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.test.service.QuestionService;

@SuppressWarnings("serial")
public class CheckUpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		//客户端传过来的最后更新服务器数据版本号
		String lastUpdateCode=req.getParameter("lastUpdateCode");
		
		QuestionService service=QuestionService.getIntance();
		//服务器数据库版本号
		String serverLastUpdateCode=service.getLastUpdateCode();
		
		String result="false";
		if(serverLastUpdateCode!=null && !"".equals(serverLastUpdateCode) && !lastUpdateCode.equals(serverLastUpdateCode)){
			result="true";
		}
		resp.getWriter().println("{\"result\":\""+result+"\"}");
	}
}
