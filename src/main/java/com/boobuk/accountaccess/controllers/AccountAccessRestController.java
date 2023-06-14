package com.boobuk.accountaccess.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.boobuk.accountaccess.models.Account;
import com.boobuk.accountaccess.services.AccountServiceImpl;

@RestController
public class AccountAccessRestController {
	@Value("${accountaccess.services.client-url}")
	private String baseUrl;
	@Autowired
	private AccountServiceImpl service;

	private ModelAndView viewHolder = new ModelAndView();

	@GetMapping("/sandbox")
	public ModelAndView getHelloPage() {
		viewHolder.setViewName("hello_page");
		viewHolder.addObject("emptyaccount", new Account());
		viewHolder.addObject("template_account", new Account());
		viewHolder.addObject("accounts", service.getAllAccounts());
		return viewHolder;
	}

	@GetMapping("/account")
	@Transactional(readOnly = true)
	@Cacheable("account-cashe")
	public ModelAndView getAccountsByName(String name) {
		List<Account> accounts = service.getAccountsByName(name);
		viewHolder.addObject("accounts", accounts);
		return viewHolder;
	}

	@PostMapping("/createAccount")
	@Transactional(readOnly = false)
	public RedirectView saveAccount(@RequestParam("name") String name) {
		RedirectView view = new RedirectView("sandbox", true);
		service.saveAccount(new Account(name));
		return view;
	}

}
