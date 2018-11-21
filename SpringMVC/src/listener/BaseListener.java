package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BaseListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	sce.getServletContext().setAttribute("base", sce.getServletContext().getInitParameter("base"));
	}
	
}
