import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RestaurantDto} from "../dto/restaurant-dto";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private restaurantURL : string;

  constructor(private http:HttpClient) {
    this.restaurantURL=`${environment.baseUrl}/restaurant`;

  }

  getAllRestaurants() : Observable<RestaurantDto>
  {
    return this.http.get<RestaurantDto>(this.restaurantURL);
  }

  getRestaurantsByOwnerId(id : number) : Observable<RestaurantDto[]>
  {
    return this.http.get<RestaurantDto[]>(`${this.restaurantURL}/owner/${id}`);
  }

  createRestaurant(restaurantDetails : RestaurantDto):Observable<RestaurantDto>
  {
    return this.http.post<RestaurantDto>(this.restaurantURL,restaurantDetails);
  }

  editRestaurant(restaurantDetails : RestaurantDto):Observable<RestaurantDto>
  {
    return this.http.put<RestaurantDto>(this.restaurantURL,restaurantDetails);
  }

  deleteRestaurant(restaurantId : number)
  {
    return this.http.delete(`${this.restaurantURL}/${restaurantId}`);
  }


}
