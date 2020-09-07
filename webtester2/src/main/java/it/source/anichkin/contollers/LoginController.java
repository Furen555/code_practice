package it.source.anichkin.contollers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.Constants;
import it.source.anichkin.exceptions.ValidationException;
import it.source.anichkin.model.Account;

@WebServlet("/login")
public class LoginController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account currentAccount = (Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
		if (currentAccount == null) {
			forwardToPage("login.jsp", req, resp);
		} else {
			resp.sendRedirect("/" + currentAccount.getCurrentRole() + "/home");
		}
		req.getSession().removeAttribute(Constants.SUCCESS_MASSAGE);
		req.getSession().removeAttribute(Constants.ERROR_MASSAGE);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		try {
			Account currentAccount = getCommonService().login(login, password);
			req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, currentAccount);
			if (currentAccount.getRoles().size() == 1) {
				currentAccount.setCurrentRole(currentAccount.getRoles().get(0).getName());
				resp.sendRedirect("/" + currentAccount.getCurrentRole() + "/home");

			} else {
				currentAccount.setCurrentRole("temp");
				req.getSession().setAttribute("roles", currentAccount.getRoles());
				resp.sendRedirect("/getRole");
			}

		} catch (ValidationException e) {
			req.setAttribute("error", e.getMessage());
			forwardToPage("login.jsp", req, resp);
		}
	}
}
