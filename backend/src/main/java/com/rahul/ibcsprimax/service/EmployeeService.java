package com.rahul.ibcsprimax.service;

import java.util.List;

import com.rahul.ibcsprimax.entity.Employee;

public interface EmployeeService {
	
	public void save(Employee employee);
	
	public void update(Employee employee);
	
	public Employee getById(Long id);
	
	public List<Employee> getAll();
	
	public void delete(Long id);
}
