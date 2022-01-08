import { Component, OnInit } from '@angular/core';
import {RestaurantService} from "../services/restaurant.service";
import {RestaurantDto} from "../dto/restaurant-dto";
import {UserProfile} from "../dto/user-profile";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.page.html',
  styleUrls: ['./add-restaurant.page.scss'],
})
export class AddRestaurantPage implements OnInit {

  name: string;

  constructor(private restaurantService:RestaurantService,private router:Router) {

  }

  ngOnInit() {
  }

  save()
  {
    if(this.name) {
      let x = new UserProfile();
      x = JSON.parse(localStorage.getItem("currentUser"));

      let restaurant = new RestaurantDto();
      restaurant.name = this.name;
      restaurant.id = 0;
      restaurant.ownerId = x.id;

      this.restaurantService.createRestaurant(restaurant).subscribe();

      this.router.navigateByUrl('view-restaurants')


    }

  }
}
