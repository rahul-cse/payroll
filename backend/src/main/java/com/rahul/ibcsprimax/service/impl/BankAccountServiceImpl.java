package com.rahul.ibcsprimax.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ibcsprimax.entity.BankAccount;
import com.rahul.ibcsprimax.repository.BankAccountRepository;
import com.rahul.ibcsprimax.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Override
	public void save(BankAccount bankAccount) {
		bankAccountRepository.save(bankAccount);
	}

	@Override
	public BankAccount get(Long id) {
		return bankAccountRepository.getOne(id);
	}

}
