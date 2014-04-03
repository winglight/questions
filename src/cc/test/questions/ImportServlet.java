package cc.test.questions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ImportServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		List<String> fileList=new ArrayList<String>();
		File file=new File(getServletConfig().getServletContext().getRealPath("/")+"\\file");
		File[] files=file.listFiles();
		for (int i = 0; i < files.length; i++) {
			fileList.add(files[i].getName());
		}
		req.setAttribute("fileList", fileList);
		
		this.getServletConfig().getServletContext().getRealPath("/");
		try {
			req.getRequestDispatcher("/jsp/import_question.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
