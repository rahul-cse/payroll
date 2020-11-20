import { Component, OnInit,  Pipe, PipeTransform } from '@angular/core';
import { Company } from 'src/app/company/company';
import { CompanyService } from 'src/app/company/company.service';
import { SalaryService } from '../salary.service';

@Component({
  selector: 'app-salary-statement-balance',
  templateUrl: './salary-statement-balance.component.html',
  styleUrls: ['./salary-statement-balance.component.css']
})
export class SalaryStatementBalanceComponent implements OnInit {

  salaryTransfer=[];
  totalSalaryTransfer=0;
  companyBalance=0;
  company: Company;

  constructor(private salaryService: SalaryService, private companyService:CompanyService) { }

  ngOnInit(): void {
    this.getSalaryStatementAndBalance();
  }

  getSalaryStatementAndBalance(){
    this.getAllSalaryTransfer();
    this.getTotalSalaryTransfer();
    this.getCompanyBalance();
  }
  getTotalSalaryTransfer() {
    this.salaryService.getTotalSalaryTransfer().subscribe(data=>{this.totalSalaryTransfer = data})
  }
  getAllSalaryTransfer() {
    this.salaryService.getAllSalaryTransfer().subscribe(data=>{this.salaryTransfer = data})
  }

  getCompanyBalance(){
    this.companyService.getCompany().subscribe(data=>{this.company=data, this.companyBalance = this.company.bankAccount.currentBalance})
  }

}
