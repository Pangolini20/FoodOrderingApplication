import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {Router} from "@angular/router";
import {CartService} from "../Providers/cart.service";
import {FoodDto} from "../dto/food-dto";
import {RestaurantDto} from "../dto/restaurant-dto";
import {CodeDto} from "../dto/code-dto";
import {CodeService} from "../services/code.service";

@Component({
  selector: 'app-discount-codes',
  templateUrl: './discount-codes.page.html',
  styleUrls: ['./discount-codes.page.scss'],
})
export class DiscountCodesPage implements OnInit {

  constructor(private menu:MenuController, private router: Router, private cartService: CartService) { }
  cart = [];
  items = [];

  ngOnInit() {
    this.items = this.cartService.getProducts();
    this.cart = this.cartService.getCart();
  }

  addToCart(product) {
    this.cartService.addProduct(product);
  }

  openCart() {
    this.router.navigate(['cart']);
  }
  _openMenuClient(){
    this.menu.enable(true, 'main');
    this.menu.open('main');
  }
 addCart(){

 }

}
