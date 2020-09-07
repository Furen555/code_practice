package it.source.anichkin.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ApplicationSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Created " + se.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Destroyed " + se.getSession().getId());
	}
}
