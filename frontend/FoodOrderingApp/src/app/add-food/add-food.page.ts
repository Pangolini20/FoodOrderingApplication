import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {FoodDto} from "../dto/food-dto";
import {FoodDetails} from "../dto/food-details";
import {FoodService} from "../services/food.service";
import {Foodcategory} from "../dto/foodcategory";

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


  constructor(private menu:MenuController,private foodService:FoodService) {}



  ngOnInit() {
  }

  addFood()
  {
    let newFood = new FoodDetails();
    newFood.name=this.name;
    newFood.description=this.description;
    newFood.price=this.price;
    newFood.category=this.category;
    this.restaurantId = 1; // TREBUIE SCHIMBAT

    this.foodService.addFood(newFood,this.restaurantId).subscribe();

  }


  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }
}
