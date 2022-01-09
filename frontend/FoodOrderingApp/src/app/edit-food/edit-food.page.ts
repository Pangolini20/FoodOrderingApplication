import { Component, OnInit } from '@angular/core';
import {Foodcategory} from "../dto/foodcategory";

@Component({
  selector: 'app-edit-food',
  templateUrl: './edit-food.page.html',
  styleUrls: ['./edit-food.page.scss'],
})
export class EditFoodPage implements OnInit {
  category!:any;
  description!:string;
  price!:number;
  name!:string;
  photo!:any;

  categories:Foodcategory[]=[Foodcategory.BURGERS,Foodcategory.PIZZA,Foodcategory.SWEETS,Foodcategory.DRINKS]
  constructor() { }

  ngOnInit() {
  }

  saveFood(){

  }

}
