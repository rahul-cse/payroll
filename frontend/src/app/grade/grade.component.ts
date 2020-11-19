import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationStart, Router } from '@angular/router';
import { faPlus, faEdit} from '@fortawesome/free-solid-svg-icons';
import { Grade } from './grade';
import {GradeService} from './grade.service';

@Component({
  selector: 'app-grade',
  templateUrl: './grade.component.html',
  styleUrls: ['./grade.component.css']
})
export class GradeComponent implements OnInit {

  viewTable:boolean;
  gradeList:Grade[];
  
  constructor(private router: Router, route: ActivatedRoute, private gradeService: GradeService) { 
    
  }




  ngOnInit(): void {
    this.viewTable = this.router.routerState.snapshot.url=='/grade'?true:false;
    this.gradeService.getAllGradeType().subscribe(data=>{this.gradeList=data,console.log(this.gradeList)});
  }
  faPlus = faPlus;
  faEdit = faEdit;

  loadFormFunc(){
    this.viewTable = false;
    this.router.navigate(["/grade/create"]);
  }

  editFormFunc(id){
    
    this.router.navigate(["grade/edit",id]);
  }
}
