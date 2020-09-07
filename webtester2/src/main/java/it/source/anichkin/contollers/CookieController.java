package it.source.anichkin.contollers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1484888996299775897L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie uiColorCookie = new Cookie("color", "red");
		uiColorCookie.setMaxAge(60*60*24*30);
		response.addCookie(uiColorCookie);
		response.getWriter().println("I've saved cookie to browser");
	}
}
