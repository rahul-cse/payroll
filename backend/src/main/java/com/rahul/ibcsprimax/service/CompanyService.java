package com.rahul.ibcsprimax.service;

import javax.validation.Valid;

import com.rahul.ibcsprimax.entity.Company;

public interface CompanyService {

	public void save(Company company);

	public Company getCompany();

	public void update(Company company);
}
