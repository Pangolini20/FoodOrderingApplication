import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FoodDto} from "../dto/food-dto";
import {FoodDetails} from "../dto/food-details";

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  foodURL:string;

  constructor(private http:HttpClient) {
    this.foodURL=`${environment.baseUrl}/food`
  }

  deleteFood(id : number)
  {
    this.http.delete(`${this.foodURL}/${id}`)
  }

  getFoodByRestaurantId(id : number) : Observable<FoodDto[]>
  {
    return this.http.get<FoodDto[]>(`${this.foodURL}/${id}`)
  }

  getFoodByCategory(category :string): Observable<FoodDto[]>
  {
    return this.http.get<FoodDto[]>(`${this.foodURL}/${category}`)
  }

  addFood(foodDetails:FoodDetails,id:number) : Observable<FoodDto>
  {
    return this.http.post<FoodDto>(`${this.foodURL}/${id}`,foodDetails);
  }

  editFood(foodDetails:FoodDetails,id:number) : Observable<FoodDto>
  {
    return this.http.put<FoodDto>(`${this.foodURL}/${id}`,foodDetails)
  }
}
