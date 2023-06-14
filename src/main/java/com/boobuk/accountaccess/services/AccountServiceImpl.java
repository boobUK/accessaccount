package com.boobuk.accountaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boobuk.accountaccess.models.Account;
import com.boobuk.accountaccess.repositories.AccountAccesRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountAccesRepository repository;

	@Override
	public Account saveAccount(Account account) {
		return repository.save(account);
	}

	@Override
	public List<Account> getAccountsByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Account getAccount(Long id) {
		Optional<Account> result = repository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public List<Account> getAllAccounts() {
		return repository.findAll();
	}

	@Override
	public void deleteAccount(Long id) {
		repository.deleteById(id);
	}
}
