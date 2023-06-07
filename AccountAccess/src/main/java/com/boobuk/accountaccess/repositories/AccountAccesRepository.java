package com.boobuk.accountaccess.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boobuk.accountaccess.models.Account;

public interface AccountAccesRepository extends JpaRepository<Account, String> {

}
