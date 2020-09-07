package it.source.anichkin.contollers;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readcookie")
public class CookieController2 extends HttpServlet {

	private static final long serialVersionUID = 1087500200230525652L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		for(Cookie cookie: request.getCookies()) {
			response.getWriter().write(cookie.getName());
			response.getWriter().write("->");
			response.getWriter().write(cookie.getValue());
			response.getWriter().write("\n");
		
		}
	}
}
