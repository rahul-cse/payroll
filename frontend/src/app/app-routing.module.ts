import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GradeComponent } from './grade/grade.component';
import { GradeFormComponent } from './grade/grade-form/grade-form.component';
import { PayscaleComponent } from './payscale/payscale.component';
import { PayscaleFormComponent } from './payscale/payscale-form/payscale-form.component';


const routes: Routes = [
   {path: 'grade',component:GradeComponent},
   {path: 'grade',component:GradeComponent,children:[{path:'create',component:GradeFormComponent}]},
   {path: 'grade',component:GradeComponent,children:[{path:'edit/:id',component:GradeFormComponent}]},
   {path: 'payscale',component:PayscaleComponent},
   {path: 'payscale',component:PayscaleComponent,children:[{path:'create',component:PayscaleFormComponent}]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
