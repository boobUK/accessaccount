package com.boobuk.accountaccess.services;

import java.util.List;

import com.boobuk.accountaccess.models.Account;

public interface AccountService {

	Account saveAccount(Account account);

	Account getAccount(Long id);

	List<Account> getAccountsByName(String names);

	List<Account> getAllAccounts();

	void deleteAccount(Long id);
}
