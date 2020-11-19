import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Grade } from '../grade';
import { GradeService } from '../grade.service';

@Component({
  selector: 'app-grade-form',
  templateUrl: './grade-form.component.html',
  styleUrls: ['./grade-form.component.css']
})
export class GradeFormComponent implements OnInit {

  grade:Grade = new Grade();
  successFlag:boolean=false;

  constructor(private gradeService: GradeService,private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params["id"];
    if(id!=null){
      this.getGrade(id)
    }
    else
      this.grade.gradeEnum=null;
    
    this.getGradeEnums();
    this.successFlag = false;
  }

  onSubmit(form:NgForm){
    const newGrade:Grade = (form.value);
    this.gradeService.save(newGrade).subscribe(data=>{if(data=='CREATED') {this.grade=new Grade(),this.grade.gradeEnum=null,this.successFlag=true,this.getGradeEnums();}});
  }

  goBack(){
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  getGrade(id){
    this.gradeService.getGradeById(id).subscribe(data=>this.grade = data);
  }

  getGradeEnums(){
    this.gradeService.getGradeType().subscribe(data=>{this.grade.gradeEnums = data; });
  }
  

}
