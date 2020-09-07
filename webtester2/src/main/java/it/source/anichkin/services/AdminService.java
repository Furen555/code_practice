package it.source.anichkin.services;

import java.util.List;

import it.source.anichkin.model.Account;

public interface AdminService {
	
	List<Account> getAll(int limit, int offset);

	boolean remove(Account account);
}
