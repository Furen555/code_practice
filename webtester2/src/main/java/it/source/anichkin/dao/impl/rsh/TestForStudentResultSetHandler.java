package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import it.source.anichkin.model.Test;

public class TestForStudentResultSetHandler implements ResultSetHandler<Test> {

	public Test handle(ResultSet rs) throws SQLException {
		Test result = new Test();
		if (rs.next()) {
			result.setId(rs.getLong("id"));
			result.setIdAccount(rs.getLong("id_account"));
			result.setName(rs.getString("name"));
			result.setDiscription(rs.getString("description"));
		}
		return result;

	}
}
