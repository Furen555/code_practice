package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.ResultSetHandler;

import it.source.anichkin.model.Account;

public class AccountResultSetHandler implements ResultSetHandler<Account> {

	public Account handle(ResultSet rs) throws SQLException {
		Account result = new Account();
		if(rs.next()) {
			result.setId(rs.getLong("id"));
			result.setLogin(rs.getString("login"));
			result.setPassword(rs.getString("password"));
			result.setFirstName(rs.getString("first_name"));
			result.setLastName(rs.getString("last_name"));
			result.setMiddleName(rs.getString("middle_name"));
			result.setEmail(rs.getString("email"));
			result.setActive(rs.getBoolean("active"));
			result.setCreated(new Date(rs.getTimestamp("created").getTime()));
			return result;
		}else {
			return null;
		}
	}
	
	
}
