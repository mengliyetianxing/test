package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Classinfo;
import services.ClassinfoServicesimpl;
import services.IClassinfoServices;

@WebServlet("/midon")
public class midon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IClassinfoServices ics = new ClassinfoServicesimpl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classinfo> li = ics.getAllClass();
		request.setAttribute("li", li);
		
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String bz = request.getParameter("bz");
		
		List<Classinfo> list = (List)request.getAttribute("li");
		String sex = request.getParameter("sex");
		String love = request.getParameter("love");
		String cla = request.getParameter("cla");
		
		if("Ò×É§".equals(cla)) {
			cla="1";
		}else if("ÎâÉ§".equals(cla)) {
			cla="2";
		}
		
		request.setAttribute("list", list);
		request.setAttribute("sex", sex);
		request.setAttribute("love", love);
		request.setAttribute("cla", cla);
		
		request.setAttribute("uid", uid);
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("birthday", birthday);
		request.setAttribute("bz", bz);
		
		List<String> lis = new ArrayList<String>();
    	lis.add("steam");
    	lis.add("origin");
    	lis.add("uplay");
    	lis.add("gog");
    	lis.add("wegay");
    	request.setAttribute("lis", lis);
		request.getRequestDispatcher("jsp/editrenwu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
