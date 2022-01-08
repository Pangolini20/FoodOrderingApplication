import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.page.html',
  styleUrls: ['./add-food.page.scss'],
})
export class AddFoodPage implements OnInit {

  category:any;
  restaurant:any;
  constructor(private menu:MenuController) { }

  ngOnInit() {
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

  categories=[
    {
      id:1,
      name: 'Burgers',
    },
    {
      id:2,
      name: 'Pizza',
    },
    {
      id:3,
      name: 'Sweets',
    },
    {
      id:4,
      name: 'Drinks',
    },
  ]
  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }


}
