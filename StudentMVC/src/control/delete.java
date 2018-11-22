package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import services.IStudentServices;
import services.StudentServicesimpl;

@WebServlet("/deleteuser")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IStudentServices iss = new StudentServicesimpl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setUid(request.getParameter("uid"));
		
		String mess = "";
		if(0!=iss.deleteuseres(u)) {
			mess="É¾³ý³É¹¦";
		}else {
			mess="É¾³ýÊ§°Ü";
		}
		List<User> list = iss.selectUsers();
		request.setAttribute("mess", mess);
		request.setAttribute("li", list);
		request.getRequestDispatcher("jsp/select.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
