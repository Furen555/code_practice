package it.source.anichkin.services.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import it.source.anichkin.dao.AccountDao;
import it.source.anichkin.exceptions.ApplicationException;
import it.source.anichkin.exceptions.ValidationException;
import it.source.anichkin.model.Account;
import it.source.anichkin.services.CommonService;
import it.source.anichkin.utils.ConnectionUtils;

public class CommonServiceImpl implements CommonService {

	private final DataSource dataSource;
	private final AccountDao accountDao;

	public CommonServiceImpl(DataSource dataSource, AccountDao accountDao) {
		this.dataSource = dataSource;
		this.accountDao = accountDao;
	}

	public Account login(String login, String password) throws ValidationException {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			Account account = accountDao.getAccountByLoginOrEmail(login);
			if (account == null) {
				throw new ValidationException("По такой эл.почте\\логину не найдено записи.");
			} else {
				if (!account.getPassword().equals(password)) {
					throw new ValidationException("Пароль не соответствует логину.");
				}
				account = accountDao.getRole(account);

				return account;
			}
		} catch (SQLException e) {
			throw new ApplicationException("Exception during login of account with login:" + login, e);
		}
	}

	public void addAccount(Account account) {
		try (Connection connection = dataSource.getConnection()) {
			ConnectionUtils.setConnection(connection);
			accountDao.addNew(account);
		} catch (SQLException e) {
			throw new ApplicationException("Exception during with add new user:", e);
		}

	}

}
