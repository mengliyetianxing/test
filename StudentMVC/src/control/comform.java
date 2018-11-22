package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Classinfo;
import pojo.User;
import services.ClassinfoServicesimpl;
import services.IClassinfoServices;
import services.IStudentServices;
import services.StudentServicesimpl;

@WebServlet("/comform")
public class comform extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IStudentServices is = new StudentServicesimpl();
    IClassinfoServices ics = new ClassinfoServicesimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		String mess = "";
		try {
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String cla = request.getParameter("select2");
			String love = request.getParameter("select");
			String bz = request.getParameter("textarea");
			u.setName(name);
			u.setPassword(password);
			u.setSex(sex);
			u.setBirthday(birthday);
			u.setCid(cla);
			u.setLove(love);
			u.setBz(bz);
	}catch (Exception e) {
		mess = "添加失败";
		e.printStackTrace();
	}
		if(is.addUs(u)!=0) {
			mess = "添加成功";
		}else {
			mess = "添加失败";
		}
		request.setAttribute("mess", mess);
		List<Classinfo> li = ics.getAllClass();
		request.setAttribute("li", li);
		request.getRequestDispatcher("jsp/addUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
