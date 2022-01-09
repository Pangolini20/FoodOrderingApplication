import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {RestaurantService} from "../services/restaurant.service";
import {UserProfile} from "../dto/user-profile";
import {RestaurantDto} from "../dto/restaurant-dto";


@Component({
  selector: 'app-view-restaurants',
  templateUrl: './view-restaurants.page.html',
  styleUrls: ['./view-restaurants.page.scss'],
})
export class ViewRestaurantsPage implements OnInit {

  owner:UserProfile=JSON.parse(localStorage.getItem('currentUser'));
  ownedRestaurants?:RestaurantDto[]=[];




  constructor(private menu:MenuController,private restaurantService:RestaurantService) {
    this.getRestaurantByOwner()
  }

  ngOnInit() {

  }

  getRestaurantByOwner()
  {
    //console.log(this.owner)
    this.restaurantService.getRestaurantsByOwnerId(this.owner.id).
    subscribe(restaurant => {this.ownedRestaurants = restaurant
    console.log(this.ownedRestaurants)} )
  }

  deleteRestaurant()
  {

  }

  editRestaurant()
  {

  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }
}
