package Utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();
		System.out.println("Session Factory Created");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();
		System.out.println("Session Factory Closed");
	}

	

}
