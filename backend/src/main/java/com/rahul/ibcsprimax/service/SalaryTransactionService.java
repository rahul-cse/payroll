package com.rahul.ibcsprimax.service;

import java.util.List;

import com.rahul.ibcsprimax.entity.SalaryTransaction;

public interface SalaryTransactionService {

	public void save(SalaryTransaction salaryTransaction);
	
	public List<SalaryTransaction> getAllSalaryTrasaction();
	
	public Double totalSalaryTransaction();
}
