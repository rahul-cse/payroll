package com.rahul.ibcsprimax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.ibcsprimax.entity.Company;
import com.rahul.ibcsprimax.repository.CompanyRepository;
import com.rahul.ibcsprimax.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

	@Override
	public Company getCompany() {
		List<Company> companyList = companyRepository.findAll();
		System.out.println(companyList.size());
		if(companyList.size()>0)
			return companyList.get(0);
		else
			return null;
	}

	@Override
	public void update(Company company) {
		companyRepository.save(company);
	}

}
