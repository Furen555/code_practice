package it.source.anichkin.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import it.source.anichkin.dao.impl.rsh.AnswearResultSetHandler;
import it.source.anichkin.dao.impl.rsh.QuestionResultSetHandler;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.model.Answear;
import it.source.anichkin.model.Question;
import it.source.anichkin.utils.ConnectionUtils;

public class AnswearDao {
	private final QueryRunner queryRunner = new QueryRunner();

	public void addNewAnswear(Answear newAnswear) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			queryRunner.insert(connection, "INSERT INTO answer VALUES (nextval('answer_seq'),?,?,?)",
					new AnswearResultSetHandler(), newAnswear.getCorrect(), newAnswear.getName(),
					newAnswear.getIdQuest());

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}
	public List<Answear> getAllAnswears(Long questId) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			return queryRunner.query(connection, "SELECT * FROM answer WHERE id_quest=?",
					new AnswearResultSetHandler(), questId);

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}
}
