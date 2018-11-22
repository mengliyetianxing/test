package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Classinfo;
import services.ClassinfoServicesimpl;
import services.IClassinfoServices;

@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IClassinfoServices ics = new ClassinfoServicesimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classinfo> li = ics.getAllClass();
		request.setAttribute("li", li);
		request.getRequestDispatcher("jsp/addUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
