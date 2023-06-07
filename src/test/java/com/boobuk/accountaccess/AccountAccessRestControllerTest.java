package com.boobuk.accountaccess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.boobuk.accountaccess.repositories.AccountAccesRepository;



@WebMvcTest
public class AccountAccessRestControllerTest {
	
	@Value("${AccountAccess.services.client-url}")
	private String baseUrl;
	
	@Autowired
	private MockMvc mockModel;
	
	@MockBean
	private AccountAccesRepository accountRepositories;
	
	@Test
	void testFindAll() {
		
	}
	
}
