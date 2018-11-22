package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Files;
import services.FilesServicesimpl;
import services.IFilesServices;

@WebServlet("/downloadcon")
public class downloadcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IFilesServices ifs = new FilesServicesimpl();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Files> li = ifs.selectAllFiles();
    	request.setAttribute("li", li);
    	request.getRequestDispatcher("jsp/download.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
