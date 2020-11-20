import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/employee/employee';
import { EmployeeService } from 'src/app/employee/employee.service';
import { SalaryService } from '../salary.service'

@Component({
  selector: 'app-salary-sheet',
  templateUrl: './salary-sheet.component.html',
  styleUrls: ['./salary-sheet.component.css']
})
export class SalarySheetComponent implements OnInit {

  empList:Employee[] = [];
  viewTable:boolean;

  constructor(private employeeService: EmployeeService, private salaryService: SalaryService) { }

  ngOnInit(): void {
    this.viewTable=true;
    this.getEmployeeSalarySheet();
  }
  getAllEmployee(){
    this.employeeService.getAllEmployees().subscribe(data=>{this.empList=data});
  }

  getEmployeeSalarySheet(){
    this.salaryService.getSalarySheet().subscribe(data=>{this.empList = data});
  }
}
