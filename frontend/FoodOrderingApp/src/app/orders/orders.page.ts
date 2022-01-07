import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {Router} from "@angular/router";
import {CartService} from "../Providers/cart.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.page.html',
  styleUrls: ['./orders.page.scss'],
})
export class OrdersPage implements OnInit {

  constructor(private menu:MenuController, private router: Router, private cartService: CartService) { }
  cart = [];
  items = [];

  ngOnInit() {
    this.items = this.cartService.getProducts();
    this.cart = this.cartService.getCart();
  }

  openCart() {
    this.router.navigate(['cart']);
  }

  _openMenuClient(){
    this.menu.enable(true, 'main');
    this.menu.open('main');
  }
}
