import { Component, OnInit } from '@angular/core';
import {Category} from "../Models/category.model";
import {MenuController} from "@ionic/angular";
import {Router} from "@angular/router";
import {CartService} from "../Providers/cart.service";
import {UserProfile} from "../dto/user-profile";


@Component({
  selector: 'app-browse',
  templateUrl: './browse.page.html',
  styleUrls: ['./browse.page.scss'],
})
export class BrowsePage implements OnInit {
  categories: Category[] = [];
  constructor(private menu:MenuController, private router: Router, private cartService: CartService) { }
  cart = [];
  items = [];

  ngOnInit() {
    this.getCategories();
    this.items = this.cartService.getProducts();
    this.cart = this.cartService.getCart();

    // pastrez aici useru dupa login :D
    console.log(localStorage.getItem('currentUser'));
    console.log(JSON.parse(localStorage.getItem('currentUser')),new UserProfile())
  }
  _openMenuClient(){
    this.menu.enable(true, 'main');
    this.menu.open('main');
  }
  openCart() {
    this.router.navigate(['cart']);
  }

  getCategories(){
    this.categories=[
      {
        id: 1,
        label: 'Burgers',
        image: 'assets/images/burger.png',
        active: true,
        path: './burgers',
      },
      {
        id: 2,
        label: 'Pizza',
        image: 'assets/images/pizza.png',
        active: true,
        path: './pizza',
      },
      {
        id: 3,
        label: 'Sweets',
        image: 'assets/images/ice.png',
        active: true,
        path: './sweets',
      },
      {
        id: 4,
        label: 'Drinks',
        image: 'assets/images/juice.png',
        active: true,
        path: './drinks',
      },
    ]
  }
}
