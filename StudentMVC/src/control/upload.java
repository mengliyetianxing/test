package control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import services.FilesServicesimpl;
import services.IFilesServices;

@WebServlet("/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IFilesServices fsi = new FilesServicesimpl(); 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		sfu.setSizeMax(1024*1024*4);
		String realpath = getServletContext().getRealPath("upload");
//		System.out.println(realpath);
		String name = "";
		String des = "";
		try {
			List<FileItem> li = sfu.parseRequest(request);
			if(li!=null) {
				for (FileItem fi : li) {
					if(fi.isFormField()) {
						des = new String(fi.getString().getBytes("iso-8859-1"), "utf-8");
					}
					else {
						name = fi.getName();
						File f = new File(name);
						File ff = new File(realpath,f.getName());
						fi.write(ff);
					}
				}
				if(name!=null&&des!=null)
				fsi.addFiles(name, des);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("mess", "<script>alert('上传成功！')</script>");
		request.getRequestDispatcher("jsp/upload.jsp").forward(request, response);
	}

}
