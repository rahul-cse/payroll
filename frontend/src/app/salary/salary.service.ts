import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { EmployeeService } from '../employee/employee.service';
import  * as restUrl  from '../restUrl.json'
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  constructor(private _http:HttpClient,private _employeeService:EmployeeService) { }

  getSalarySheet():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/salary/salarysheet');
  }

  getPayscaleByEmployee(id:number):Observable<any>{
    return this._http.get(restUrl.backendUrl+'/salary/salarybyemp/'+id);
  }

  salaryTransfer(salaryTransfer:any):Observable<any>{
    return this._http.post(restUrl.backendUrl+'/salary/transfer',salaryTransfer).pipe(
      catchError(this.handleError))
  }

  getAllSalaryTransfer():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/salary/salarytransfer/');
  }

  getTotalSalaryTransfer():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/salary/totalsalarytransfer/')
  }



  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
        // client-side error
        errorMessage = `Error: ${error.error.message}`;
    } else {
        // server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
  
}
