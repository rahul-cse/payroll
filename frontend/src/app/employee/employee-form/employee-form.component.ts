import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BankAccount } from 'src/app/bankAccount/bankAccount';
import { Grade } from 'src/app/grade/grade';
import { GradeService } from 'src/app/grade/grade.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {

  emp:Employee = new Employee();
  grade:Grade = new Grade();
  bankAccount:BankAccount = new BankAccount();
  successFlag:boolean=false;
  grades:Grade[];

  constructor(private employeeService:EmployeeService,private gradeService:GradeService,private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {

    let id = this.route.snapshot.params["id"];
    if(id!=null){
      this.getEmployee(id)
    }
    else{
      this.grade.id = null;
      this.emp.grade = this.grade;
      this.bankAccount.accountType=null;
      this.getAccountTypes();
      this.getAllGrades();
    }
    
  
  }
  getEmployee(id) {
    this.getAccountTypes();
    this.getAllGrades();
    this.employeeService.getEmpById(id).subscribe(data=>{this.emp=data,console.log(this.emp)})
  }

  onSubmit(form:NgForm){
    console.log(this.emp);
    if(this.emp.id==null){
      this.employeeService.save(this.emp).subscribe(data=>{if(data=='CREATED'){
        this.successFlag = true;
        this.emp = new Employee();
        this.grade = new Grade();
        this.bankAccount = new BankAccount();
        this.grade.id = null;
        this.emp.grade = this.grade;
        this.bankAccount.accountType=null;
        this.emp.bankAccount = this.bankAccount;
      }
    })
    }
    else{
      this.employeeService.update(this.emp).subscribe(data=>{if(data=='OK'){
        this.successFlag = true;
        this.emp = new Employee();
        this.grade = new Grade();
        this.bankAccount = new BankAccount();
        this.grade.id = null;
        this.emp.grade = this.grade;
        this.bankAccount.accountType=null;
        this.emp.bankAccount = this.bankAccount;
      }
    })
  }
 
  }

  getAccountTypes(){
    this.employeeService.getAccountTypes().subscribe(data=>{this.bankAccount.accountTypes=data,this.emp.bankAccount = this.bankAccount});
  }

  getAllGrades(){
    this.gradeService.getAllGradeType().subscribe(data=>{this.grades = data,console.log(this.emp)});
  }

  
  goBack(){
    this.router.navigate(['../'], { relativeTo: this.route });
  }

}
