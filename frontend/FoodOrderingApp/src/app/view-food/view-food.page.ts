import { Component, OnInit } from '@angular/core';
import {MenuController, NavController} from "@ionic/angular";


@Component({
  selector: 'app-view-food',
  templateUrl: './view-food.page.html',
  styleUrls: ['./view-food.page.scss'],
})
export class ViewFoodPage implements OnInit {

  foods: Array<{}>;
  restaurant:any;

  constructor(private menu:MenuController, public navCtrl: NavController) {
    this.foods = [
      {
          id:1,
          photo:'img1',
          name:'ok',
          category: 'Burger',
          description: 'Cheese',
          price: 10
      }
      ]
  }


  restaurants=[
    {
      id:1,
      name: 'Restaurant1',
    },
    {
      id:2,
      name: 'Restaurant2',
    },
  ]

  ngOnInit() {
  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }

  remove(no){
    this.foods.splice(no,1);
  }



}
