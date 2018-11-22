package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import services.IStudentServices;
import services.StudentServicesimpl;

@WebServlet("/checkName")
public class checkName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IStudentServices iss = new StudentServicesimpl();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		List<User> li = iss.selectUsersByName(name);
		PrintWriter pw = response.getWriter();
		if(li!=null&&li.size()>0) {
			pw.write("true");
		}else {
			pw.write("flase");
		}
		pw.flush();
		pw.close();
	}

}
