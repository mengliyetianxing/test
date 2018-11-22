package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import services.IStudentServices;
import services.StudentServicesimpl;

@WebServlet("/updateuser")
public class updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentServices iss = new StudentServicesimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		String mess = "";
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String cla = request.getParameter("select2");
		String love = request.getParameter("select");
		String bz = request.getParameter("textarea");
		String uid = request.getParameter("uid");
		u.setUid(uid);
		u.setName(name);
		u.setPassword(password);
		u.setSex(sex);
		u.setBirthday(birthday);
		u.setCid(cla);
		u.setLove(love);
		u.setBz(bz);
		if(iss.updateuseres(u)!=0) {
			mess = "修改成功";
		}else {
			mess = "修改失败";
		}
		request.setAttribute("mess",mess );
		request.getRequestDispatcher("jsp/editrenwu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
