import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {Router} from "@angular/router";
import {CartService} from "../Providers/cart.service";
import { Clipboard } from '@ionic-native/clipboard/ngx';
import {CodeDto} from "../dto/code-dto";
import {CodeService} from "../services/code.service";

@Component({
  selector: 'app-discount-codes',
  templateUrl: './discount-codes.page.html',
  styleUrls: ['./discount-codes.page.scss'],
})
export class DiscountCodesPage implements OnInit {


  codeList:CodeDto[];

  constructor(private menu:MenuController,
              private router: Router,
              private cartService: CartService,
              private cb: Clipboard,
              private codeService:CodeService)
  {
    this.codeService.getAllCodes().subscribe(codes =>
    {
      //date sort incoming
      this.codeList=codes;
    })
  }

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
 addCode(){

  }

}
