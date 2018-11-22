package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.SplitPage;
import pojo.User;
import services.IStudentServices;
import services.StudentServicesimpl;

@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentServices iss = new StudentServicesimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String index = request.getParameter("index");
		int pageIndex = 0;
		if(index==null||"".equals(index)) {
			pageIndex = 1;
		}else {
			try {
				pageIndex = Integer.valueOf(index);
			}catch (Exception e) {
				pageIndex = 1;
			}
		}
		SplitPage<User> sp = iss.selectUsers(pageIndex, 5);
		request.setAttribute("sp", sp);
		request.getRequestDispatcher("jsp/select.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
