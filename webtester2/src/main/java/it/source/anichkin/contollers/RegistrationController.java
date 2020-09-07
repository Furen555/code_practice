package it.source.anichkin.contollers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.Constants;
import it.source.anichkin.model.Account;

@WebServlet(urlPatterns = { "/registration" })
public class RegistrationController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("/registration.jsp", req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if ((String) req.getAttribute("password1") == (String) req.getAttribute("password2")) {
				Account registrationAccount = new Account();
				registrationAccount.setEmail(req.getParameter("email"));
				registrationAccount.setFirstName((String) req.getParameter("firstName"));
				registrationAccount.setLastName((String) req.getParameter("lastName"));
				registrationAccount.setMiddleName((String) req.getParameter("middleName"));
				registrationAccount.setLogin((String) req.getParameter("login"));
				registrationAccount.setPassword((String) req.getParameter("password1"));
				getCommonService().addAccount(registrationAccount);

				req.getSession().setAttribute(Constants.SUCCESS_MASSAGE,
						"You creating account was success, please check you emal : " + registrationAccount.getEmail());
				resp.sendRedirect("/login");
			}
		} catch (Exception e) {
			req.getSession().setAttribute(Constants.ERROR_MASSAGE,
					"Creation account falled, plese try again");
			resp.sendRedirect("/login");
		}

	}

}
