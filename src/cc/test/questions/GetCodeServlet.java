package cc.test.questions;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.test.service.CodeService;

@SuppressWarnings("serial")
public class GetCodeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		CodeService service=CodeService.getIntance();
		
		String result=service.getAllCode();
		resp.getWriter().println(result);
	}
	
}
