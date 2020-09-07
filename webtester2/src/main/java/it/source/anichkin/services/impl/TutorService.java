package it.source.anichkin.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import it.source.anichkin.dao.impl.AnswearDao;
import it.source.anichkin.dao.impl.QuestionDao;
import it.source.anichkin.dao.impl.TestDao;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.model.Account;
import it.source.anichkin.model.Answear;
import it.source.anichkin.model.Question;
import it.source.anichkin.model.Test;
import it.source.anichkin.services.AdminService;
import it.source.anichkin.utils.ConnectionUtils;

public class TutorService {

	private final DataSource dataSource;
	private final TestDao testDao;
	private final QuestionDao questionDao;
	private final AnswearDao answearDao;

	public TutorService(DataSource dataSource, TestDao testDao, QuestionDao questionDao, AnswearDao answearDao) {
		this.dataSource = dataSource;
		this.testDao = testDao;
		this.questionDao = questionDao;
		this.answearDao = answearDao;

	}

	public boolean createNewTest(Test newTest) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			testDao.addNewTest(newTest);
			return true;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	public boolean createNewAnswear(Answear newAnswear) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			answearDao.addNewAnswear(newAnswear);
			return true;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	public boolean createNewQuestion(Question newQuestion) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			questionDao.addNewQuestion(newQuestion);
			return true;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	public List<Test> getAllTest() {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			return testDao.selectAllTest();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	public List<Question> getAllQuests(Long testId) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			return questionDao.selectAllQuests(testId);
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	public List<Answear> getAllAnswears(Long questId) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			return answearDao.getAllAnswears(questId);
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	public Test getTestForStudent(long testId) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			Test currentTest = testDao.selectTestForStudent(testId);
			currentTest.setQuestions(questionDao.selectAllQuests(currentTest.getId()));
			for (int i = 0; i < currentTest.getQuestions().size(); i++) {
				currentTest.getQuestions().get(i)
						.setAnswears(getAllAnswears(currentTest.getQuestions().get(i).getId()));
				;
			}

			return currentTest;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

}
