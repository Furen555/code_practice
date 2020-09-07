package it.source.anichkin.contollers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.source.anichkin.context.ApplicationContext;
import it.source.anichkin.services.AdminService;
import it.source.anichkin.services.CommonService;
import it.source.anichkin.services.impl.TutorService;

public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = -1745923969777520720L;
	
	private ApplicationContext applicationContext;
	
	@Override
	public final void init() throws ServletException {
		applicationContext = ApplicationContext.getApplicationContext(getServletContext());
		initServlet();
	}
	
	protected void initServlet()throws ServletException {
		
	}
	
	public final int getPageCount(int totalCount, int itemsPerPage) {
		int res = totalCount / itemsPerPage;
		if(res * itemsPerPage != totalCount) {
			res++;
		}
		return res;
	}
	
	public final int getPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	protected void forwardToPage(String pageName, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("currentPage", "/WEB-INF/views/" + pageName);
		req.getRequestDispatcher("/WEB-INF/views/page-template.jsp").forward(req, resp);
	}
	
	public CommonService getCommonService() {
		return applicationContext.getCommonService();
	}
	
	public AdminService getAdminService() {
		return applicationContext.getAdminService();
	}
	public TutorService getTutorService() {
		return applicationContext.getTutorService();
	}
}
