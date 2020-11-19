import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import  * as restUrl  from '../restUrl.json'

@Injectable({
  providedIn: 'root'
})
export class PayscaleService {

  constructor(private _http:HttpClient) { }



  getAllGradeType():Observable<any>{
    return this._http.get(restUrl.backendUrl+'/grade/');
  }
}
