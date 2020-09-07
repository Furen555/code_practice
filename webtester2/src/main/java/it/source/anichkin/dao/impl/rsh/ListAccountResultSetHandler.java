package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import it.source.anichkin.model.Account;

public class ListAccountResultSetHandler implements ResultSetHandler<List<Account>> {

	@Override
	public List<Account> handle(ResultSet rs) throws SQLException {
		List<Account> result = new ArrayList<>();
		while(rs.next()) {
			Account account = new Account();
			account.setId(rs.getLong("id"));
			account.setLogin(rs.getString("login"));
			account.setPassword(rs.getString("password"));
			account.setFirstName(rs.getString("first_name"));
			account.setLastName(rs.getString("last_name"));
			account.setMiddleName(rs.getString("middle_name"));
			account.setEmail(rs.getString("email"));
			account.setActive(rs.getBoolean("active"));
			account.setCreated(new Date(rs.getTimestamp("created").getTime()));
			result.add(account);
		}
		return result;
	}

}
