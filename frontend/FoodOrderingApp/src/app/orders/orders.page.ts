import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";
import {Router} from "@angular/router";
import {CartService} from "../Providers/cart.service";
import {OrderService} from "../services/order.service";
import {Orderdto} from "../dto/orderdto";
import {UserProfile} from "../dto/user-profile";
import {FoodDto} from "../dto/food-dto";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.page.html',
  styleUrls: ['./orders.page.scss'],
})
export class OrdersPage implements OnInit {

  ordersList:Orderdto[];
  userId:UserProfile = JSON.parse(localStorage.getItem("currentUser"));
  total:number[] = [];

  constructor(private menu:MenuController,
              private router: Router,
              private cartService: CartService,
              private orderService: OrderService){

    this.orderService.getOrder(this.userId.id)
      .subscribe( orderList =>
      {
        this.ordersList=orderList
        let arr = this.ordersList.map(x => x.foodDtoList)
        arr.forEach( x => this.total.push(this.calculateTotal(x)))
        console.log(this.total)
      }
    )
  }
  cart = [];
  items = [];

  calculateTotal(foodDto:FoodDto[]):number
  {
    let sum = foodDto.map(x => x.price)
    return sum.reduce((a,b) => a + b)
  }

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
