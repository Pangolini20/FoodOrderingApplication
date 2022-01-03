import { Component, OnInit } from '@angular/core';
import {Category} from "../Models/category.model";
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-browse',
  templateUrl: './browse.page.html',
  styleUrls: ['./browse.page.scss'],
})
export class BrowsePage implements OnInit {
  categories: Category[] = [];
  constructor(private menu:MenuController) { }

  ngOnInit() {
    this.getCategories();
  }
  _openMenuClient(){
    this.menu.enable(true, 'main');
    this.menu.open('main');
  }

  getCategories(){
    this.categories=[
      {
        id: 1,
        label: 'Burgers',
        image: 'assets/images/burger.png',
        active: true,
      },
      {
        id: 2,
        label: 'Pizza',
        image: 'assets/images/pizza.png',
        active: false,
      },
      {
        id: 3,
        label: 'Sweets',
        image: 'assets/images/ice.png',
        active: false,
      },
      {
        id: 4,
        label: 'Drinks',
        image: 'assets/images/juice.png',
        active: false,
      },
    ]
  }
}
