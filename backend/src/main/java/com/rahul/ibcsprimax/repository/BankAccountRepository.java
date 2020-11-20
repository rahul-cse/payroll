package com.rahul.ibcsprimax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.ibcsprimax.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}
