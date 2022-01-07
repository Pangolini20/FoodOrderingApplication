import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import {CartService} from "../Providers/cart.service";


@Component({
  selector: 'app-sweets',
  templateUrl: './sweets.page.html',
  styleUrls: ['./sweets.page.scss'],
})
export class SweetsPage implements OnInit {

  constructor(private router: Router, private cartService: CartService) { }
  cart = [];
  items = [];

  sliderConfig = {
    slidesPerView: 1.6,
    spaceBetween: 10,
    centeredSlides: true
  };
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

}
