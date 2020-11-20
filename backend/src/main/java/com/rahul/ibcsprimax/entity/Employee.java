package com.rahul.ibcsprimax.entity;

import java.beans.Transient;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@Column(unique=true)
	private Integer employeeId;
	private String address;
	private String mobile;

	
	@JoinColumn(nullable=false)
	@OneToOne
	private Grade grade;
	@OneToOne(cascade= {CascadeType.ALL,CascadeType.REFRESH})
	@JoinColumn(name="bank_account_id", nullable = false)
	private BankAccount bankAccount;
	
	@javax.persistence.Transient
	private Payscale Payscale;
	
	
	@PrePersist
	void beforeSave(){
		Random rand = new Random(); 
        int empId = rand.nextInt(9999); 
        
	}
	



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Payscale getPayscale() {
		return Payscale;
	}

	public void setPayscale(Payscale payscale) {
		Payscale = payscale;
	}
	
	
	
}
