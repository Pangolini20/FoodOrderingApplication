import { Component, OnInit } from '@angular/core';
import {Foodcategory} from "../dto/foodcategory";
import {FoodDetails} from "../dto/food-details";
import {FoodService} from "../services/food.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-food',
  templateUrl: './edit-food.page.html',
  styleUrls: ['./edit-food.page.scss'],
})
export class EditFoodPage implements OnInit {
  category!:Foodcategory;
  description!:string;
  price!:number;
  name!:string;
  photo!:any;
  foodId=history.state.data;

  categories:Foodcategory[]=[Foodcategory.BURGERS,Foodcategory.PIZZA,Foodcategory.SWEETS,Foodcategory.DRINKS]
  constructor(private foodService:FoodService,private router:Router) {

  }

  ngOnInit() {
  }

  saveFood(){
    let food= new FoodDetails();
    food.name=this.name;
    food.price=this.price;
    food.category=this.category;
    food.description=this.description;

    this.foodService.editFood(food,this.foodId).subscribe();
    this.router.navigateByUrl('view-food');

  }
}
