import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Grade } from 'src/app/grade/grade';
import { GradeService } from 'src/app/grade/grade.service';
import { Payscale } from '../Payscale';

@Component({
  selector: 'app-payscale-form',
  templateUrl: './payscale-form.component.html',
  styleUrls: ['./payscale-form.component.css']
})
export class PayscaleFormComponent implements OnInit {

  payscale:Payscale = new Payscale();
  grade:Grade = new Grade();
  successFlag:boolean=false;

  constructor(private router: Router, private route: ActivatedRoute, private gradeService: GradeService) { }

  ngOnInit(): void {
    this.getLowestGrade();
  }

  onSubmit(form:NgForm){
    const newPayscale = form.value;
    console.log(newPayscale);
  }

  goBack(){
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  getLowestGrade(){
    this.gradeService.getLowestGrade().subscribe(data=>{this.grade = data,this.payscale.grade = this.grade,console.log(this.payscale)});
  }


}
