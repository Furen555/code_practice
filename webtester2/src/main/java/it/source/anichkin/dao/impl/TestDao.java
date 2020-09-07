package it.source.anichkin.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import it.source.anichkin.dao.impl.rsh.TestForStudentResultSetHandler;
import it.source.anichkin.dao.impl.rsh.TestResultSetHandler;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.model.Test;
import it.source.anichkin.utils.ConnectionUtils;

public class TestDao {
	private final QueryRunner queryRunner = new QueryRunner();

	public void addNewTest(Test newTest) {
		Connection connection = ConnectionUtils.getConnection();
		try {

			queryRunner.insert(connection, "INSERT INTO test VALUES (nextval('test_seq'),?,?,?)",
					new TestResultSetHandler(), newTest.getIdAccount(), newTest.getName(), newTest.getDiscription());

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}

	public List<Test> selectAllTest() {
		Connection connection = ConnectionUtils.getConnection();
		try {
			return queryRunner.query(connection, "SELECT * FROM test", new TestResultSetHandler());

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}
	
	public Test selectTestForStudent(long testId) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			return queryRunner.query(connection, "SELECT * FROM test WHERE id=?", new TestForStudentResultSetHandler(), testId);

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}
}
