import { Injectable } from '@angular/core';
import {RestaurantDto} from "../dto/restaurant-dto";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  restaurantDtoList : RestaurantDto[];
}
