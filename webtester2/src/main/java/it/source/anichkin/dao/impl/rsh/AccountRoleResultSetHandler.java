package it.source.anichkin.dao.impl.rsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import it.source.anichkin.model.Role;

public class AccountRoleResultSetHandler implements ResultSetHandler<List<Role>> {

	public List<Role> handle(ResultSet rs) throws SQLException {
		List<Role> roles = new ArrayList<>();
		while (rs.next()) {
			Role role = new Role();
			role.setId(rs.getLong("id"));
			switch (rs.getInt("id_role")) {
			case (1):
				role.setName("admin");
			break;
			case (2):
				role.setName("tutor");
			break;
			case (3):
				role.setName("supertutor");
			break;
			case (4):
				role.setName("student");
			break;
			}
			roles.add(role);
		}
		return roles;
	}

}
