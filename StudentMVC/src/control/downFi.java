package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/down")
public class downFi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realpath = getServletContext().getRealPath("upload");
		String name = request.getParameter("name");
		
		File file = new File(realpath+"\\"+name);
		if(file.exists()) {
			FileInputStream fs = new FileInputStream(file);
			String sname = URLEncoder.encode(file.getName(), "utf-8");
			byte[] bs = new byte[fs.available()];
			fs.read(bs);
			response.setHeader("Content-Disposition","attachment; filename="+sname+"");  
			ServletOutputStream sos = response.getOutputStream();
			sos.write(bs);
			sos.flush();
			sos.close();
		}
		
	}

}
