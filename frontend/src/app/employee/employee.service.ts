import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import  * as restUrl  from '../restUrl.json'
import { Observable, throwError } from 'rxjs';
import { Employee } from './employee';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private _http: HttpClient) { }

  getAccountTypes():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/bankacc/accountTypes')
  }

  getAllEmployees():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/emp')
  }

  getEmpById(id: number):Observable<any> {
    return this._http.get(restUrl.backendUrl+'/emp/'+id)
  }

  save(_emp:Employee):Observable<any>{
    return this._http.post(restUrl.backendUrl+'/emp/create',_emp).pipe(
                          catchError(this.handleError))
  }

  update(_emp: Employee):Observable<any> {
    return this._http.put(restUrl.backendUrl+'/emp/update',_emp).pipe(
      catchError(this.handleError))
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
