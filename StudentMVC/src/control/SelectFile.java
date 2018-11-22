package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import pojo.Files;
import services.FilesServicesimpl;
import services.IFilesServices;

@WebServlet("/selectFile")
public class SelectFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IFilesServices ifs = new FilesServicesimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Files> li = ifs.selectAllFiles();
		String str = JSONArray.fromObject(li).toString();
		PrintWriter pw = response.getWriter();
		pw.write(str);
		pw.flush();
		pw.close();
	}

}
