import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GradeComponent } from './grade/grade.component';
import { GradeFormComponent } from './grade/grade-form/grade-form.component';
import { PayscaleComponent } from './payscale/payscale.component';
import { PayscaleFormComponent } from './payscale/payscale-form/payscale-form.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeFormComponent } from './employee/employee-form/employee-form.component';
import { SalaryComponent } from './salary/salary.component';
import { SalarySheetComponent } from './salary/salary-sheet/salary-sheet.component';
import { SalaryStatementBalanceComponent } from './salary/salary-statement-balance/salary-statement-balance.component';
import { CompanyComponent } from './company/company.component';


const routes: Routes = [
   {path: 'grade',component:GradeComponent},
   {path: 'grade',component:GradeComponent,children:[{path:'create',component:GradeFormComponent}]},
   {path: 'grade',component:GradeComponent,children:[{path:'edit/:id',component:GradeFormComponent}]},
   {path: 'payscale',component:PayscaleComponent},
   {path: 'payscale',component:PayscaleComponent,children:[{path:'create',component:PayscaleFormComponent}]},
   {path: 'payscale',component:PayscaleComponent,children:[{path:'edit/:id',component:PayscaleFormComponent}]},
   {path: 'employee',component:EmployeeComponent},
   {path: 'employee',component:EmployeeComponent,children:[{path:'create',component:EmployeeFormComponent}]},
   {path: 'employee',component:EmployeeComponent,children:[{path:'edit/:id',component:EmployeeFormComponent}]},
   {path: 'company', component:CompanyComponent},
   {path: 'salarytransfer',component:SalaryComponent},
   {path: 'salarysheet',component:SalarySheetComponent},
   {path: 'salarystatement',component:SalaryStatementBalanceComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
