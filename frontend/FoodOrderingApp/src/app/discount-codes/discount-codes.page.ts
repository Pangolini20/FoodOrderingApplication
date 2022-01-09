import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {Router} from "@angular/router";
import {CartService} from "../Providers/cart.service";
import { Clipboard } from '@ionic-native/clipboard/ngx';

@Component({
  selector: 'app-discount-codes',
  templateUrl: './discount-codes.page.html',
  styleUrls: ['./discount-codes.page.scss'],
})
export class DiscountCodesPage implements OnInit {

  constructor(private menu:MenuController, private router: Router, private cartService: CartService,private cb: Clipboard) { }
  cart = [];
  items = [];
  textCopy:string = "Forget the failures.";
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

  copyCode(){
      this.cb.copy(this.textCopy);
      console.log("Copy text");
  }

}
