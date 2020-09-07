package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import it.source.anichkin.model.Question;

public class QuestionResultSetHandler implements ResultSetHandler<List<Question>> {

	public List<Question> handle(ResultSet rs) throws SQLException {
		List<Question> list = new ArrayList<>();
		while (rs.next()) {
			Question result = new Question();
			result.setId(rs.getLong("id"));
			result.setIdTest(rs.getLong("id_test"));
			result.setName(rs.getString("name"));
			list.add(result);
		}
		return list;

	}

}