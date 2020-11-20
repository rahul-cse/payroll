import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import  * as restUrl  from '../restUrl.json'
import { Observable, throwError } from 'rxjs';
import { Company } from './company';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private _http: HttpClient) { }

  getCompany():Observable<any>{
    return this._http.get(restUrl.backendUrl + '/company');
  }

  save(_company:Company):Observable<any>{
    return this._http.post(restUrl.backendUrl+'/company/create',_company).pipe(
                          catchError(this.handleError))
  }

    addNewBalance(_company:Company):Observable<any>{
    return this._http.put(restUrl.backendUrl+'/company/balance',_company).pipe(
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
