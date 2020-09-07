package it.source.anichkin.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import it.source.anichkin.dao.impl.rsh.QuestionResultSetHandler;
import it.source.anichkin.dao.impl.rsh.TestResultSetHandler;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.model.Question;
import it.source.anichkin.model.Test;
import it.source.anichkin.utils.ConnectionUtils;

public class QuestionDao {
	private final QueryRunner queryRunner = new QueryRunner();

	public void addNewQuestion(Question newQuestion) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			queryRunner.insert(connection, "INSERT INTO question VALUES (nextval('question_seq'),?,?)",
					new QuestionResultSetHandler(), newQuestion.getIdTest(), newQuestion.getName());

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}

	public List<Question> selectAllQuests(Long testId) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			return queryRunner.query(connection, "SELECT * FROM question WHERE id_test=?",
					new QuestionResultSetHandler(), testId);

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}
}
