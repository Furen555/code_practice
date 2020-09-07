package it.source.anichkin.contollers.tutor;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.source.anichkin.contollers.AbstractController;
import it.source.anichkin.model.Question;

@WebServlet(urlPatterns = { "/tutor/quest" })
public class QuestController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("testId") != null) {
			long testId = Long.parseLong(req.getParameter("testId"));
			List<Question> questions = getTutorService().getAllQuests(testId);
			req.setAttribute("questions", questions);
			req.getSession().setAttribute("currentTest", testId);
			forwardToPage("tutor/quest.jsp", req, resp);
		} else {
			long testId = Long.parseLong(req.getSession().getAttribute("currentTest").toString());
			List<Question> questions = getTutorService().getAllQuests(testId);
			req.setAttribute("questions", questions);
			req.getSession().setAttribute("currentTest", testId);
			forwardToPage("tutor/quest.jsp", req, resp);
		}

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("addQuest") != null) {
			Question question = new Question(Long.parseLong(req.getSession().getAttribute("currentTest").toString()),
					req.getParameter("addQuest"));
			getTutorService().createNewQuestion(question);
		}
		resp.sendRedirect("/tutor/quest");
	}
}
