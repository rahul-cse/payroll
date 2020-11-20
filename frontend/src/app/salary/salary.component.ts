import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Company } from '../company/company';
import { CompanyService } from '../company/company.service';
import { Employee } from '../employee/employee';
import { EmployeeService } from '../employee/employee.service';
import { Payscale } from '../payscale/Payscale';
import { SalaryService } from './salary.service';

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {

  empList:Employee[] = [];
  employee:Employee=null;
  payscale:Payscale;
  company:Company;
  totalSalary:number = 0;
  companyBalance:number = 0;
  balanceInput:boolean = false;
  
  successFlag:boolean=false;
  addBalancceSuccesFlag:boolean=false;
  

  constructor(private employeeService: EmployeeService,private companyService: CompanyService, private salaryService: SalaryService) { }

  ngOnInit(): void {
    this.getEmployeeList();
    //this.getEmployeeSalarySheet();
  }

  getEmployeeList(){
    this.employeeService.getAllEmployees().subscribe(data=>{this.empList=data});
  }

  getEmployeeSalarySheet(){
    this.salaryService.getSalarySheet().subscribe(data=>{this.empList = data});
  }

  getPayScaleByEmployee(id){
    this.salaryService.getPayscaleByEmployee(id).subscribe(data=>{
                                                                  this.payscale=data,
                                                                  this.totalSalary =this.payscale.basic+this.payscale.houseRent+this.payscale.medicalAllowance})
  }

  getCompany(){
    this.companyService.getCompany().subscribe(data=>{this.company=data})
  }

  onChangeEmp(){
    if(this.employee!=null){
      this.payscale = null;
      this.company = null;
      this.getPayScaleByEmployee(this.employee);
      this.getCompany();
      this.successFlag=false;
      this.addBalancceSuccesFlag=false;
    }
  }

  onSubmit(){

    this.successFlag=false;
    this.addBalancceSuccesFlag=false;

    if(this.company.bankAccount.currentBalance<this.totalSalary){
      this.balanceInput = true;
    }
    else{
      const employee = {id:this.employee};
      const salaryTransfer = { employee:employee,totalSalary:this.totalSalary,payscale:this.payscale};
      console.log(salaryTransfer);
      this.balanceInput = false;
      this.salaryService.salaryTransfer(salaryTransfer).subscribe(data=>{console.log(data),this.totalSalary=0,this.successFlag = true;this.payscale=null});
    }
    
  }

  addBalance(){
    console.log(this.companyBalance);
    this.company.bankAccount.currentBalance = this.company.bankAccount.currentBalance + this.companyBalance;
    this.companyService.addNewBalance(this.company).subscribe(data=>{this.addBalancceSuccesFlag=true,this.balanceInput=false,this.companyBalance=0})
    
  }

}
