import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { faPlus, faEdit} from '@fortawesome/free-solid-svg-icons';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  empList:Employee[];
  viewTable:boolean;

  constructor(private employeeService:EmployeeService, private router: Router, route: ActivatedRoute) { }

  ngOnInit(): void {
    this.viewTable = this.router.routerState.snapshot.url=='/employee'?true:false;
    this.getAllEmployee();
  }

  loadFormFunc(){
    this.viewTable = false;
    this.router.navigate(["/employee/create"]);
  }
  faPlus = faPlus;
  faEdit = faEdit;

  editFormFunc(id){
    this.router.navigate(["employee/edit",id]);
  }

  getAllEmployee(){
    this.employeeService.getAllEmployees().subscribe(data=>{this.empList=data});
  }
}
