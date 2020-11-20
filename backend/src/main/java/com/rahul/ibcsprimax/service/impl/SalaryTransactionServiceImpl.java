package com.rahul.ibcsprimax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.ibcsprimax.entity.SalaryTransaction;
import com.rahul.ibcsprimax.repository.SalaryTransactionRepository;
import com.rahul.ibcsprimax.service.SalaryTransactionService;

@Service
public class SalaryTransactionServiceImpl implements SalaryTransactionService {

	@Autowired
	SalaryTransactionRepository salaryTransactionRepository;
	
	@Override
	public void save(SalaryTransaction salaryTransaction) {
	
		salaryTransactionRepository.save(salaryTransaction);
	}

	@Override
	public List<SalaryTransaction> getAllSalaryTrasaction() {
		return salaryTransactionRepository.findAll();
	}

	@Override
	public Double totalSalaryTransaction() {
		return salaryTransactionRepository.findSalarySum();
	}

}
