package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import services.IStudentServices;
import services.StudentServicesimpl;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentServices iss = new StudentServicesimpl();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("textfield");
		String password = request.getParameter("textfield2");
		String ucode = request.getParameter("textfield3");
		User u = iss.login(name, password);
		if(u!=null) {
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("checkcode");
			
			if((code.toLowerCase()).equals((ucode.toLowerCase()))) {
				session.setAttribute("uigin", name);
				response.sendRedirect("Index.jsp");
			}else {
				response.sendRedirect("Login.jsp?err=001");		
			}
		}else {
			response.sendRedirect("Login.jsp?err=001");			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
