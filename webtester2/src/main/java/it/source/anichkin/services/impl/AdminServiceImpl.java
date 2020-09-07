package it.source.anichkin.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import it.source.anichkin.dao.AccountDao;
import it.source.anichkin.dao.ResultDao;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.model.Account;
import it.source.anichkin.services.AdminService;
import it.source.anichkin.utils.ConnectionUtils;

public class AdminServiceImpl implements AdminService {

	private final DataSource dataSource;
	private final AccountDao accountDao;
	private final ResultDao resultDao;

	public AdminServiceImpl(DataSource dataSource, AccountDao accountDao, ResultDao resultDao) {
		this.dataSource = dataSource;
		this.accountDao = accountDao;
		this.resultDao = resultDao;
	}

	public boolean remove(Account account) {
		try (Connection connection = dataSource.getConnection()) {
			connection.setAutoCommit(false);
			ConnectionUtils.setConnection(connection);
			accountDao.remove(account.getId());
			resultDao.removeAllAccountResults(account.getId());
			connection.commit();
			return true;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

	@Override
	public List<Account> getAll(int limit, int offset) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			return accountDao.getAll(limit, offset);
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			ConnectionUtils.clearConnection();
		}
	}

}
