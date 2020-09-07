package it.source.anichkin.services;

import it.source.anichkin.exceptions.ValidationException;
import it.source.anichkin.model.Account;

public interface CommonService {

	Account login(String login, String password) throws ValidationException;
	public void addAccount(Account account);
}
