package it.source.anichkin.context;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;

import it.source.anichkin.dao.AccountDao;
import it.source.anichkin.dao.ResultDao;
import it.source.anichkin.dao.impl.AccountDaoImpl;
import it.source.anichkin.dao.impl.AnswearDao;
import it.source.anichkin.dao.impl.QuestionDao;
import it.source.anichkin.dao.impl.ResultDaoImpl;
import it.source.anichkin.dao.impl.TestDao;
import it.source.anichkin.services.AdminService;
import it.source.anichkin.services.CommonService;
import it.source.anichkin.services.impl.AdminServiceImpl;
import it.source.anichkin.services.impl.CommonServiceImpl;
import it.source.anichkin.services.impl.TutorService;

public final class ApplicationContext {
	public static final String APP_CONTEXT = "APP_CONTEXT";

	private ApplicationContext() {
		dataSource = setupDataSource();
		accountDao = new AccountDaoImpl();
		resultDao = new ResultDaoImpl();
		commonService = new CommonServiceImpl(dataSource, accountDao);
		adminService = new AdminServiceImpl(dataSource, accountDao, resultDao);

		answearDao = new AnswearDao();
		questionDao = new QuestionDao();
		testDao = new TestDao();
		tutorService = new TutorService(dataSource, testDao, questionDao, answearDao);
	}

	public static ApplicationContext getApplicationContext(ServletContext sc) {
		ApplicationContext context = (ApplicationContext) sc.getAttribute(APP_CONTEXT);
		if (context == null) {
			context = new ApplicationContext();
			sc.setAttribute(APP_CONTEXT, context);
		}
		return context;
	}

	private final BasicDataSource dataSource;

	private final CommonService commonService;
	private final AdminService adminService;
	private final TutorService tutorService;

	private final AccountDao accountDao;
	private final ResultDao resultDao;
	private final AnswearDao answearDao;
	private final QuestionDao questionDao;
	private final TestDao testDao;
	
	
	public TutorService getTutorService() {
		return tutorService;
	}

	public AnswearDao getAnswearDao() {
		return answearDao;
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public TestDao getTestDao() {
		return testDao;
	}

	

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ResultDao getResultDao() {
		return resultDao;
	}

	public void shutDown() {
		try {
			dataSource.close();
		} catch (Exception e) {
		}
	}

	private BasicDataSource setupDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/webtester");
		ds.setUsername("admin");
		ds.setPassword("admin");
		ds.setInitialSize(5);
		ds.setMaxTotal(20);
		return ds;
	}
}
