package it.source.anichkin.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.source.anichkin.context.ApplicationContext;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext.getApplicationContext(sce.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		ApplicationContext.getApplicationContext(sce.getServletContext()).shutDown();
	}
}
