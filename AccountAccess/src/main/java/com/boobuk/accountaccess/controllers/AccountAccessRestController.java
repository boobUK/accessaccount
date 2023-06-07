package com.boobuk.accountaccess.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boobuk.accountaccess.models.Account;
import com.boobuk.accountaccess.repositories.AccountAccesRepository;

@RestController
public class AccountAccessRestController {

	@Value("${AccountAccess.services.client-url}")
	private String baseUrl;

	@Autowired
	private AccountAccesRepository repository;

	@GetMapping("/create_account")
	public ModelAndView createAccount() {
		ModelAndView view = new ModelAndView("account_form");
		Account account = new Account("Some interest name");
		view.addObject("template_account", account);
		return view;
	}

	@GetMapping("/accounts")
	@Transactional(readOnly = true)
	public ModelAndView getAccounts() {
		ModelAndView view = new ModelAndView("accountview");
		view.addObject("accounts", repository.findAll());
		return view;
	}

	@PostMapping("/")
	@Transactional(readOnly = false)
	public ModelAndView createAccount(@RequestBody String name) {
		ModelAndView view = new ModelAndView("account_list");
		repository.save(new Account(name));
		Map<String, List<Account>> iterAccount = Collections.singletonMap("accounts", repository.findAll());
		view.addAllObjects(iterAccount);
		return view;
	}

}
