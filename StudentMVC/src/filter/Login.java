package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		//放过特殊请求
		if(request.getRequestURI().endsWith("Login.jsp")||request.getRequestURI().endsWith("login")) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		//放过静态资源
		if(request.getRequestURI().contains("images")||request.getRequestURI().contains("css")||request.getRequestURI().contains("js")) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		if(request.getSession().getAttribute("u")!=null) {
			arg2.doFilter(arg0, arg1);
		}else {
			response.sendRedirect("Login.jsp");
		}
	}

}
