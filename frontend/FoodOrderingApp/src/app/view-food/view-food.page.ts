import { Component, OnInit } from '@angular/core';
import {MenuController, NavController} from "@ionic/angular";
import {FoodDto} from "../dto/food-dto";
import {RestaurantDto} from "../dto/restaurant-dto";
import {FoodService} from "../services/food.service";
import {RestaurantService} from "../services/restaurant.service";
import {UserProfile} from "../dto/user-profile";


@Component({
  selector: 'app-view-food',
  templateUrl: './view-food.page.html',
  styleUrls: ['./view-food.page.scss'],
})
export class ViewFoodPage implements OnInit {


  foodList?:FoodDto[];
  restaurantList?:RestaurantDto[];
  ownerProfile:UserProfile=JSON.parse(localStorage.getItem("currentUser"));


  restaurant:any;

  constructor(private menu:MenuController,
              public navCtrl: NavController,
              private foodService:FoodService,
              private restaurantService:RestaurantService) {

    restaurantService.getRestaurantsByOwnerId(this.ownerProfile.id).subscribe(list => this.restaurantList = list);
  }

  ngOnInit() {
  }

  onChange(restaurantId)
  {
    this.foodService.getFoodByRestaurantId(restaurantId).subscribe( list => this.foodList = list);
  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }

  remove(foodId:number,i){ // nu se sterge din frontend
    console.log(foodId)
    this.foodService.deleteFood(foodId).subscribe();
  }



}
