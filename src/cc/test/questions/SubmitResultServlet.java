package cc.test.questions;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.test.model.ResultModel;
import cc.test.service.TestResultService;

@SuppressWarnings("serial")
public class SubmitResultServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		ResultModel model=new ResultModel();
		model.setEmail(req.getParameter("email"));
		model.setQuestionAnswerCodes(req.getParameter("questionAnswerCodes"));
		model.setQuestionCodes(req.getParameter("questionCodes"));
		model.setRightPercent(Double.parseDouble(req.getParameter("rightPercent")));
		
//		model.setSubmitTime(Long.parseLong(req.getParameter("submitTime")));
		
		TestResultService service=TestResultService.getIntance();
		service.insertTestResult(model);
	}
	
}