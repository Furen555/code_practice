package it.source.anichkin.dao;

import java.util.List;

import it.source.anichkin.model.Account;

public interface AccountDao {

	Account getAccountByLoginOrEmail(String login);
	
	boolean remove(Long accountId);
	public Account getRole(Account currentAccount);

	List<Account> getAll(int limit, int offset);
	public void addNew(Account account);
}
