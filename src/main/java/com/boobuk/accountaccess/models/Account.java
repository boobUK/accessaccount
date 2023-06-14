package com.boobuk.accountaccess.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	private String clientId;
	private String name;
	private String permissions;
	@Column(name = "X-Token")
	private String xToken;
	@JsonProperty("accounts")
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection()
	private List<Card> cards;

	public Account() {
		this.cards = new ArrayList<>();
	}

	public Account(String name) {
		super();
		this.name = name;
	}

	public Account(Account account, String xToken) {
		this.clientId = account.getClientId();
		this.name = account.getName();
		this.permissions = account.getPermissions();
		this.cards = account.getCards();
		this.xToken = xToken;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String accountId) {
		this.clientId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getxToken() {
		return xToken;
	}

	public void setxToken(String xToken) {
		this.xToken = xToken;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Account [clientId=" + clientId + ", name=" + name + ", permissions=" + permissions + ", xToken="
				+ xToken + ", cards=" + cards + "]";
	}

}
