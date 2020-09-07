
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

@WebFilter(filterName = "userRoleFilter")
public class userRoleFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String reqUri = req.getRequestURI();
		Account currentAcc = (Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);

		if (currentAcc != null) {
			if (!StringUtils.startsWithIgnoreCase(reqUri, "/logout")
					|| !StringUtils.startsWithIgnoreCase(reqUri, "/getRole")) {
				if (!StringUtils.startsWithIgnoreCase(reqUri, "/" + currentAcc.getCurrentRole())) {
					resp.sendRedirect("/" + currentAcc.getCurrentRole() + "/home");
				}
			}

			else {

				chain.doFilter(req, resp);
			}

		}
	}
}
