package com.boobuk.accountaccess.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boobuk.accountaccess.models.Card;

public interface CardRepository extends JpaRepository<Card, String> {

}
