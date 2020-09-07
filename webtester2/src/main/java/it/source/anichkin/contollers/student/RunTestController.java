package it.source.anichkin.contollers.student;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.source.anichkin.contollers.AbstractController;
import it.source.anichkin.model.Question;
import it.source.anichkin.model.Test;

@WebServlet(urlPatterns = { "/student/runtest" })
public class RunTestController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("student/runtest.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long testId = Long.parseLong(req.getParameter("testId"));
		Test currentTest = getTutorService().getTestForStudent(testId);
		req.setAttribute("testName", currentTest.getName());
		req.setAttribute("testDiscription", currentTest.getDiscription());

		req.setAttribute("questions", currentTest.getQuestions());
		
		
		
		forwardToPage("student/runtest.jsp", req, resp);
	}
}
