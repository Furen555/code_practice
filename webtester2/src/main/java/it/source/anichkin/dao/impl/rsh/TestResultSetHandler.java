package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import it.source.anichkin.model.Test;

public class TestResultSetHandler implements ResultSetHandler<List<Test>> {

	public List<Test> handle(ResultSet rs) throws SQLException {
		List<Test> list = new ArrayList<>();
		while (rs.next()) {
			Test result = new Test();
			result.setId(rs.getLong("id"));
			result.setIdAccount(rs.getLong("id_account"));
			result.setName(rs.getString("name"));
			result.setDiscription(rs.getString("description"));
			list.add(result);
		}
		return list;

	}
}
