import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {CodeDetails} from "../dto/code-details";
import {Observable} from "rxjs";
import {CodeDto} from "../dto/code-dto";

@Injectable({
  providedIn: 'root'
})

export class CodeService {

  codeURL: string;

  constructor(private http:HttpClient) {
    this.codeURL=`${environment.baseUrl}/code`
  }

  deleteCode(id:number):Observable<any>
  {
    return this.http.delete<any>(`${this.codeURL}/${id}`);
  }

  getDiscountCodes(id:number):Observable<CodeDto[]>
  {
    return this.http.get<CodeDto[]>(`${this.codeURL}/${id}`);
  }

  createCode(id:number,codeDetails:CodeDetails):Observable<CodeDto>
  {
    return this.http.post<CodeDto>(`${this.codeURL}/${id}`,codeDetails);
  }

  editCode(id:number,codeDetails:CodeDetails):Observable<CodeDto>
  {
    return this.http.put<CodeDto>(`${this.codeURL}/${id}`,codeDetails)
  }
}
