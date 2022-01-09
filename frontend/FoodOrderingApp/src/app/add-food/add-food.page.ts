import {Component, OnInit} from '@angular/core';
import {MenuController} from "@ionic/angular";
import {FoodDetails} from "../dto/food-details";
import {FoodService} from "../services/food.service";
import {RestaurantDto} from "../dto/restaurant-dto";
import {RestaurantService} from "../services/restaurant.service";
import {UserProfile} from "../dto/user-profile";
import {Foodcategory} from "../dto/foodcategory";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.page.html',
  styleUrls: ['./add-food.page.scss'],
})
export class AddFoodPage implements OnInit {

  category!:any;
  description!:string;
  price!:number;
  name!:string;
  restaurantId:number;
  restaurants?:RestaurantDto[];
  owner:UserProfile = JSON.parse(localStorage.getItem("currentUser"));

  categories:Foodcategory[]=[Foodcategory.BURGERS,Foodcategory.PIZZA,Foodcategory.SWEETS,Foodcategory.DRINKS]

  constructor(private menu:MenuController,
              private foodService:FoodService,
              private restaurantService:RestaurantService,
              private router:Router) {
    this.restaurantService.getRestaurantsByOwnerId(this.owner.id).subscribe(x => this.restaurants = x);
  }


  ngOnInit() {
  }

  checkIfNotEmpty(){
    if(this.name && this.description && this.price && this.category && this.restaurantId)
    {
      return true;
    }

    return false;
  }

  addFood()
  {
    if(this.checkIfNotEmpty()) {
      let newFood = new FoodDetails();
      newFood.name = this.name;
      newFood.description = this.description;
      newFood.price = this.price;
      newFood.category = this.category;

      console.log(newFood);
      console.log(this.restaurantId);

      this.foodService.addFood(newFood,this.restaurantId).subscribe();
      this.router.navigateByUrl('/view-food')
    }
  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }


}
