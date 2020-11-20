package com.rahul.ibcsprimax.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.ibcsprimax.entity.Company;
import com.rahul.ibcsprimax.service.CompanyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("")
	public Company getCompany() {
		return companyService.getCompany();
	}

	@PostMapping("/create")
	public Company saveCompany(@RequestBody @Valid Company company) {
		companyService.save(company);
		return company;
	}
	
	@PutMapping("/balance")
	public void updateCompanyBalance(@RequestBody @Valid Company company) {
		companyService.update(company);
	}
}
