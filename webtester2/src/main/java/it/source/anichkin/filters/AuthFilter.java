package it.source.anichkin.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.source.anichkin.Constants;
import it.source.anichkin.model.Account;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String reqUri = req.getRequestURI();
		Account currentAcc = (Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
		if (isUrlForLoggedInAccount(reqUri) && currentAcc == null) {
			resp.sendRedirect("/login");
		} else {
			chain.doFilter(req, resp);
		}
	}

	private boolean isUrlForLoggedInAccount(String reqUri) {
		return StringUtils.startsWithIgnoreCase(reqUri, "/admin")
				|| StringUtils.startsWithIgnoreCase(reqUri, "/student")
				|| StringUtils.startsWithIgnoreCase(reqUri, "/tutor")
				|| StringUtils.startsWithIgnoreCase(reqUri, "/supertutor")
				|| StringUtils.startsWithIgnoreCase(reqUri, "/getRole");
	}
}
