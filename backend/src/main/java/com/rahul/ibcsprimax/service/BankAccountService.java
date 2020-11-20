package com.rahul.ibcsprimax.service;

import com.rahul.ibcsprimax.entity.BankAccount;

public interface BankAccountService {

	public void save(BankAccount bankAccount);
	
	public BankAccount get(Long id);
}
