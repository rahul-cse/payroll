package com.rahul.ibcsprimax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rahul.ibcsprimax.entity.SalaryTransaction;

public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Long>{

	@Query("Select sum(st.totalSalary) from SalaryTransaction st")
	Double findSalarySum();

}
