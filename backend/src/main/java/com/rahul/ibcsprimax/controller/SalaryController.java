package com.rahul.ibcsprimax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.ibcsprimax.entity.BankAccount;
import com.rahul.ibcsprimax.entity.Company;
import com.rahul.ibcsprimax.entity.Employee;
import com.rahul.ibcsprimax.entity.Payscale;
import com.rahul.ibcsprimax.entity.SalaryTransaction;
import com.rahul.ibcsprimax.service.BankAccountService;
import com.rahul.ibcsprimax.service.CompanyService;
import com.rahul.ibcsprimax.service.EmployeeService;
import com.rahul.ibcsprimax.service.PayscaleService;
import com.rahul.ibcsprimax.service.SalaryTransactionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/salary")
public class SalaryController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	PayscaleService payscaleService;
	@Autowired
	CompanyService companyService;
	@Autowired
	BankAccountService bankAccountService;
	@Autowired
	SalaryTransactionService salaryTransactionService;

	@GetMapping("/salarysheet")
	public List<Employee> getAllEmployeeSalarySheet() {
		System.out.println("salary sheet");
		List<Employee> empList = employeeService.getSalarySheet();
		empList.forEach(emp-> emp.setPayscale(payscaleService.findByGrade(emp.getGrade())));
		return employeeService.getSalarySheet();
	}
	
	@GetMapping("/salarybyemp/{id}")
	public Payscale getSalaryByEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeService.getById(id);
		Payscale payscale = payscaleService.findByGrade(employee.getGrade());
		return payscale;
	}
	
	@Transactional
	@PostMapping("/transfer")
	public void salaryTransfer(@RequestBody SalaryTransaction salaryTransaction) {
		Company company = companyService.getCompany();
		BankAccount bankAccount = bankAccountService.get(company.getBankAccount().getId());
		bankAccount.setCurrentBalance(bankAccount.getCurrentBalance()-salaryTransaction.getTotalSalary());
		Employee employee = employeeService.getById(salaryTransaction.getEmployee().getId());
		BankAccount empBankAccount = employee.getBankAccount();
		Double currentBalance = empBankAccount.getCurrentBalance()!=null?empBankAccount.getCurrentBalance():0;
		empBankAccount.setCurrentBalance(currentBalance + salaryTransaction.getTotalSalary());
		bankAccountService.save(empBankAccount);
		company.setBankAccount(bankAccount);
		salaryTransactionService.save(salaryTransaction);
	}
	
	@GetMapping("/salarytransfer")
	public List<SalaryTransaction> salaryTransferList(){
		return salaryTransactionService.getAllSalaryTrasaction();
	}
	@GetMapping("/totalsalarytransfer")
	public Double totalSalaryTransfer() {
		return salaryTransactionService.totalSalaryTransaction();
	}
	
}
