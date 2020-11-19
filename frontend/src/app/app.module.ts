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


@NgModule({
  declarations: [
    AppComponent,
    GradeComponent,
    GradeFormComponent,
    PayscaleComponent,
    PayscaleFormComponent,
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
