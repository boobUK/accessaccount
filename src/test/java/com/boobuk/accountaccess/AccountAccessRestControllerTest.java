package com.boobuk.accountaccess;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import com.boobuk.accountaccess.models.Account;
import com.boobuk.accountaccess.services.AccountServiceImpl;

@WebMvcTest
public class AccountAccessRestControllerTest {

	private static final String HOME_URL = "/accessacc/sandbox";
	private static final String CREATE_ACC_URL = "/accessacc/createAccount";
	private static final String FILTER_ACC_URL = "/accessacc/account";
	private static final String CONTEXT_URL = "/accessacc";

	private Account testAccount;

	@Value("${accountaccess.services.account-templates}")
	private String templatesPath;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountServiceImpl service;

	@BeforeEach
	void setUp() {
		testAccount = new Account("test name");
	}

	@Test
	void testHomePage() throws Exception {
		doNothing().when(service).getAllAccounts();
		mockMvc.perform(get(HOME_URL).contextPath(CONTEXT_URL)).andExpect(status().isOk());
	}

	@Test
	void testFindByName() throws Exception {
		when(service.getAccountsByName(any())).thenReturn(Arrays.asList(testAccount));
		mockMvc.perform(get(FILTER_ACC_URL).contextPath(CONTEXT_URL)).andExpect(status().isOk());
	}

	@Test
	void testSaveAccount() throws Exception {	
		when(service.saveAccount(any())).thenReturn(testAccount);
		mockMvc.perform(get(CREATE_ACC_URL).contextPath(CONTEXT_URL)).andExpect(status().isOk());
	}

}
