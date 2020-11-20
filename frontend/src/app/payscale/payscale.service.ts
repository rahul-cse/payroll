import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import  * as restUrl  from '../restUrl.json'
import { Payscale } from './Payscale';

@Injectable({
  providedIn: 'root'
})
export class PayscaleService {

  constructor(private _http:HttpClient) { }

  headers = new HttpHeaders({'Content-Type': 'application/json'});


  getAllPayscale():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/payscale/');
  }

  getPayscaleById(id:number):Observable<any>{
    return this._http.get(restUrl.backendUrl+'payscale/'+id);
  }

  save(_payscale: Payscale):Observable<any>{
    console.log(_payscale);
    return this._http.post(restUrl.backendUrl+'/payscale/create',_payscale,{headers: this.headers, responseType: 'json'}).pipe(
      catchError(this.handleError)
    )
  }

  update(_payscale: Payscale):Observable<any>{
    return this._http.put(restUrl.backendUrl+'/payscale/update',_payscale,{headers: this.headers, responseType: 'json'}).pipe(
      catchError(this.handleError)
    )
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
