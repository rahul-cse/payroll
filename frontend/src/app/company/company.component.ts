import { Component, OnInit } from '@angular/core';
import { Company } from './company';
import { NgForm } from '@angular/forms';
import { BankAccount } from '../bankAccount/bankAccount';
import { CompanyService } from './company.service';
import { EmployeeService } from '../employee/employee.service';


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  company:Company = new Company();
  successFlag:boolean=false;
  bankAccount:BankAccount = new BankAccount();

  constructor(private companyService:CompanyService, private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.getAccountTypes();
    this.getCompany();
    this.company.bankAccount = this.bankAccount;
    this.company.bankAccount.accountType=null;
    console.log(this.company)
  }

  getCompany(){
    this.companyService.getCompany().subscribe(data=>{if(data!=null)this.company=data});
  }

  getAccountTypes(){
    this.employeeService.getAccountTypes().subscribe(data=>{this.bankAccount.accountTypes=data});
  }

  onSubmit(form:NgForm){
    console.log(this.company);
    this.companyService.save(this.company).subscribe(data=>{this.successFlag=true,this.company=data})
  }

  goBack(){

  }

}
