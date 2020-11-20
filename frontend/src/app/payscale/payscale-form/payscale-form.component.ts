import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Grade } from 'src/app/grade/grade';
import { GradeService } from 'src/app/grade/grade.service';
import { Payscale } from '../Payscale';
import { PayscaleService } from '../payscale.service';

@Component({
  selector: 'app-payscale-form',
  templateUrl: './payscale-form.component.html',
  styleUrls: ['./payscale-form.component.css']
})
export class PayscaleFormComponent implements OnInit {

  payscale:Payscale = new Payscale();
  grade:Grade = new Grade();
  successFlag:boolean=false;

  constructor(private router: Router, private route: ActivatedRoute, private gradeService: GradeService, private payscaleService: PayscaleService) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params["id"];
    if(id!=null){
      this.getPayscale(id)
    }
    else{
      this.grade.gradeEnum=null;
      this.getLowestGrade();
    }
      
  }
  getPayscale(id) {
    this.payscaleService.getPayscaleById(id).subscribe(data=>{this.payscale=data,console.log(this.payscale)});
  }

  onSubmit(form:NgForm){
    if(this.payscale.id==null){
      this.payscaleService.save(this.payscale).subscribe(data=>{if(data=='CREATED'){
        console.log(data),
        this.successFlag=true;
        this.payscale = new Payscale();
        this.grade = new Grade();
        this.payscale.grade = this.grade;
        this.getLowestGrade();
        }                                                
      });
    }
    else{
      this.payscaleService.update(this.payscale).subscribe(data=>{
        this.successFlag=true;
        this.payscale = new Payscale();
        this.grade = new Grade();
        this.payscale.grade = this.grade;
        this.getLowestGrade();
      })
    }
    
  }

  goBack(){
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  getLowestGrade(){
    this.gradeService.getLowestGrade().subscribe(data=>{this.grade = data,this.payscale.grade = this.grade});
  }


}
