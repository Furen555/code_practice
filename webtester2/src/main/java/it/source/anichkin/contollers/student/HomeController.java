package it.source.anichkin.contollers.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.contollers.AbstractController;
import it.source.anichkin.model.Account;
import it.source.anichkin.model.Test;

@WebServlet("/student/home")
public class HomeController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Test> tests = getTutorService().getAllTest();
		req.setAttribute("tests", tests);
		forwardToPage("student/home.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		resp.sendRedirect("/student/home");
	}
}
