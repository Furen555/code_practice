package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import it.source.anichkin.model.Answear;

public class AnswearResultSetHandler implements ResultSetHandler<List<Answear>> {

	public List<Answear> handle(ResultSet rs) throws SQLException {
		List<Answear> list = new ArrayList<>();

		while (rs.next()) {
			Answear result = new Answear();
			result.setId(rs.getLong("id"));
			result.setIdQuest(rs.getLong("id_quest"));
			result.setName(rs.getString("name"));
			result.setCorrect(rs.getBoolean("correct"));
			list.add(result);

		}
		return list;
	}

}