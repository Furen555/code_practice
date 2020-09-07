package it.source.anichkin.contollers.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.Constants;
import it.source.anichkin.contollers.AbstractController;
import it.source.anichkin.model.Account;
import it.source.anichkin.model.Test;

@WebServlet(urlPatterns = { "/tutor/home", "/supertutor/home" })
public class HomeController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Test> tests = getTutorService().getAllTest();
		req.setAttribute("tests", tests);
		forwardToPage("tutor/home.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (((String) req.getParameter("addTestName") != null)
				&& ((String) req.getParameter("addTestDescription") != null)) {
			Account currentAccount = (Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
			Test newTest = new Test(req.getParameter("addTestName").toString(),
					req.getParameter("addTestDescription").toString(), currentAccount.getId());
			getTutorService().createNewTest(newTest);

		}
		resp.sendRedirect("/tutor/home");

	}
}
