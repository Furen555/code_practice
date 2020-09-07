package it.source.anichkin.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import it.source.anichkin.dao.AccountDao;
import it.source.anichkin.dao.impl.rsh.AccountResultSetHandler;
import it.source.anichkin.dao.impl.rsh.AccountRoleResultSetHandler;
import it.source.anichkin.dao.impl.rsh.ListAccountResultSetHandler;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.model.Account;
import it.source.anichkin.utils.ConnectionUtils;

public class AccountDaoImpl implements AccountDao {

	private final QueryRunner queryRunner = new QueryRunner();

	public Account getAccountByLoginOrEmail(String login) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			return queryRunner.query(connection, "SELECT * FROM account WHERE login=? OR email=?",
					new AccountResultSetHandler(), login, login);
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

	public Account getRole(Account currentAccount) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			currentAccount.setRoles(queryRunner.query(connection, "SELECT * FROM account_role WHERE id_account=?",
					new AccountRoleResultSetHandler(), currentAccount.getId()));
			;
			return currentAccount;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}

	@Override
	public boolean remove(Long accountId) {
//тут метод удаляет всё из таблички акаунт и таблички роль
		return false;
	}

	@Override
	public List<Account> getAll(int limit, int offset) {
		Connection connection = ConnectionUtils.getConnection();
		try {
			return queryRunner.query(connection, "SELECT * FROM account LIMIT ? OFFSET ?",
					new ListAccountResultSetHandler(), limit, offset);
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

	public void addNew(Account account) {
		Connection connection = ConnectionUtils.getConnection();

		try {

			Account currentAccount = queryRunner.insert(connection,
					"INSERT INTO account VALUES (nextval('account_seq'),?,?,?,?,?,?)", new AccountResultSetHandler(),
					account.getFirstName(), account.getLastName(), account.getMiddleName(), account.getEmail(),
					account.getPassword(), account.getLogin());
			queryRunner.insert(connection, "INSERT INTO account_role VALUES (nextval('account_role_seq'),?,?)",
					new AccountRoleResultSetHandler(), currentAccount.getId(), 4);

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}

}
