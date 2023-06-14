package com.boobuk.accountaccess.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boobuk.accountaccess.models.Account;

public interface AccountAccesRepository extends JpaRepository<Account, Long> {
	List<Account> findByName(String name);
}
