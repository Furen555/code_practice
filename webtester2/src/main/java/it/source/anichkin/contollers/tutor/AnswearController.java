package it.source.anichkin.contollers.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.contollers.AbstractController;
import it.source.anichkin.model.Answear;

@WebServlet(urlPatterns = { "/tutor/answear" })
public class AnswearController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("questId") != null) {
			long questId = Long.parseLong(req.getParameter("questId"));
			List<Answear> answears = getTutorService().getAllAnswears(questId);
			req.setAttribute("answears", answears);
			req.getSession().setAttribute("currentQuest", questId);
			forwardToPage("tutor/answear.jsp", req, resp);
		} else {
			long questId = Long.parseLong(req.getSession().getAttribute("currentQuest").toString());
			List<Answear> answears = getTutorService().getAllAnswears(questId);
			req.setAttribute("answears", answears);
			req.getSession().setAttribute("currentQuest", questId);
			forwardToPage("tutor/answear.jsp", req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ((req.getParameter("addAnswear") != null) && (req.getParameter("correct") != null)) {
			boolean correct = Boolean.parseBoolean(req.getParameter("correct"));
			Answear answear = new Answear(Long.parseLong(req.getSession().getAttribute("currentQuest").toString()),
					req.getParameter("addAnswear"), correct);
			getTutorService().createNewAnswear(answear);
		}
		resp.sendRedirect("/tutor/answear");

	}
}
