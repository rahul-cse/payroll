import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payscale } from './Payscale';
import { PayscaleService} from './payscale.service';
import { faPlus, faEdit} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-payscale',
  templateUrl: './payscale.component.html',
  styleUrls: ['./payscale.component.css']
})
export class PayscaleComponent implements OnInit {

  viewTable:boolean;
  payscaleList:Payscale[] = [];

  constructor(private router: Router, private payscaleService:PayscaleService) { }

  ngOnInit(): void {
    this.viewTable = this.router.routerState.snapshot.url=='/payscale'?true:false;
    this.getAllPayscale();
  }

  faPlus = faPlus;
  faEdit = faEdit;

  loadFormFunc(){
    this.viewTable = false;
    this.router.navigate(["/payscale/create"]);
  }

  getAllPayscale(){
    //this.payscaleService.getAllGradeType().subscribe(data=>{console.log(data)});
  }

  getLowestGrade(){

  }

}
