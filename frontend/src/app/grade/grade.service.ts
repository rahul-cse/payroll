import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Grade } from './grade'
import  * as restUrl  from '../restUrl.json'
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'; 


@Injectable({
  providedIn: 'root'
})
export class GradeService {

  headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private _http: HttpClient) { }

  save(_grade: Grade):Observable<any>{
    console.log(_grade);
    return this._http.post(restUrl.backendUrl+'/grade/create',_grade,{headers: this.headers, responseType: 'json'}).pipe(
      catchError(this.handleError)
    )
    
 
    
  }

  
  getGradeType():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/grade/gradeTypes');
  }

  getAllGradeType():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/grade/');
  }

  getGradeById(id:number):Observable<any>{
    return this._http.get(restUrl.backendUrl+'/grade/'+id);
  }

  getLowestGrade():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/grade/lowest');
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
