package it.source.anichkin.contollers;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.Constants;
import it.source.anichkin.contollers.AbstractController;
import it.source.anichkin.model.Account;

@WebServlet("/getRole")
public class checkRoleController extends AbstractController {
	private static final long serialVersionUID = -5297778884336388618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		forwardToPage("chooserole.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account currentAccount =(Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
		currentAccount.setCurrentRole(req.getParameter("roles"));
		resp.sendRedirect("/" + currentAccount.getCurrentRole() + "/home");
	}
}
