package com.boobuk.accountaccess.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
	@Id
	@Nonnull
	private String id;
	private String sendId;
	private double currencyCode;
	private String cashbackType;
	private double balance;
	private double creditLimit;
	@ElementCollection
	private List<String> maskedPan;
	private String type;
	private String iban;

	public Card() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.trim();
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public Double getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(Double currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCashbackType() {
		return cashbackType;
	}

	public void setCashbackType(String cashbackType) {
		this.cashbackType = cashbackType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public List<String> getMaskedPan() {
		return maskedPan;
	}

	public void setMaskedPan(List<String> maskedPan) {
		this.maskedPan = maskedPan;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", sendId=" + sendId + ", currencyCode=" + currencyCode + ", cashbackType="
				+ cashbackType + ", balance=" + balance + ", creditLimit=" + creditLimit + ", maskedPan=" + maskedPan
				+ ", type=" + type + ", iban=" + iban + "]";
	}

}
