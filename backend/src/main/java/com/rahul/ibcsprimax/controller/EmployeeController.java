package com.rahul.ibcsprimax.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.ibcsprimax.entity.Employee;

@RestController
public class EmployeeController {

	@GetMapping()
	public Employee getEmployee() {
		return null;
	}
	
	@PostMapping("/create")
	public Employee saveEmployee(@RequestBody @Valid Employee employee) {
		return null;
		
	}
}
