package cc.test.questions;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.test.model.UserModel;
import cc.test.service.UserService;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		UserModel user=new UserModel();
		user.setAndroid_sid(req.getParameter("android_sid"));
		user.setCiudad(req.getParameter("ciudad"));
		user.setColegio(req.getParameter("colegio"));
		user.setEmail(req.getParameter("email"));
		user.setRegion(req.getParameter("region"));
		user.setRut(req.getParameter("rut"));
		
		UserService service=UserService.getIntance();
		service.insertUser(user);
	}
	
}
