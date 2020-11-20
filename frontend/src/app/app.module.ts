import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GradeComponent } from './grade/grade.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { GradeFormComponent } from './grade/grade-form/grade-form.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PayscaleComponent } from './payscale/payscale.component';
import { PayscaleFormComponent } from './payscale/payscale-form/payscale-form.component';
import { EmployeeComponent } from './employee/employee.component';
import { SalaryComponent } from './salary/salary.component';
import { EmployeeFormComponent } from './employee/employee-form/employee-form.component';
import { SalarySheetComponent } from './salary/salary-sheet/salary-sheet.component';
import { CompanyComponent } from './company/company.component';
import { SalaryStatementBalanceComponent } from './salary/salary-statement-balance/salary-statement-balance.component';


@NgModule({
  declarations: [
    AppComponent,
    GradeComponent,
    GradeFormComponent,
    PayscaleComponent,
    PayscaleFormComponent,
    EmployeeComponent,
    SalaryComponent,
    EmployeeFormComponent,
    SalarySheetComponent,
    CompanyComponent,
    SalaryStatementBalanceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
