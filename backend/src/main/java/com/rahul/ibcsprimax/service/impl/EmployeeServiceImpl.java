package com.rahul.ibcsprimax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ibcsprimax.entity.Employee;
import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.repository.EmployeeRepository;
import com.rahul.ibcsprimax.service.BankAccountService;
import com.rahul.ibcsprimax.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BankAccountService bankAccountService;
	
	@Override
	public void save(Employee employee) {
		employee.setBankAccount(employee.getBankAccount());
		employeeRepository.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employee.setBankAccount(employee.getBankAccount());
		employeeRepository.save(employee);
		
	}

	@Override
	public Employee getById(Long id) {
		Optional<Employee> empOpt = employeeRepository.findById(id);
		return empOpt.get();
	}

	@Override
	public List<Employee> getAll() {

		return employeeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getSalarySheet() {
		return employeeRepository.findEmployeeSalary();
	}

	

}
