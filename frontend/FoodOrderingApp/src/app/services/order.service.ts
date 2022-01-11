import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Orderdto} from "../dto/orderdto";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderURL:string;

  constructor(private http:HttpClient) {
    this.orderURL=`${environment.baseUrl}/order`
  }

  createOrder(order:Orderdto):Observable<Orderdto>
  {
    return this.http.post<Orderdto>(this.orderURL,order);
  }

  getOrder(id:number):Observable<Orderdto>
  {
   return this.http.get<Orderdto>(this.orderURL);
  }
}
