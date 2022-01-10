import { Component, OnInit } from '@angular/core';
import { CartService } from "../Providers/cart.service";
import {CodeDto} from "../dto/code-dto";
import {Orderdto} from "../dto/orderdto";
import {UserProfile} from "../dto/user-profile";
import {FoodDto} from "../dto/food-dto";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss'],
})
export class CartPage implements OnInit {
  selectedItems = [];

  total=0;
  // Codes=[
  //   {
  //     value:1,
  //   },
  //   {
  //     value:2,
  //   }
  // ]
  Codes:CodeDto[]=[]

  discount:number=0;
  constructor(private cartService: CartService) { }

  ngOnInit() {
    let items = this.cartService.getCart();
    let selected = {};
    for (let obj of items) {
      if (selected[obj.id]) {
        selected[obj.id].count++;
      } else {
        selected[obj.id] = {...obj, count: 1};
      }
    }
    this.selectedItems = Object.keys(selected).map(key => selected[key])
    this.selectedItems = this.selectedItems.sort((a,b) => (a.restaurantName > b.restaurantName) ? 1 : ((b.restaurantName > a.restaurantName) ? -1 : 0))
    this.Codes=this.cartService.getCodes();
    let arr=  this.Codes.map(x => x.value);
    for(let i = 0;i< arr.length;i=i+1)
    {
      this.discount+= arr[i]
    }

    console.log(this.discount);
    this.total = this.selectedItems.reduce((a, b) => a + (b.count * b.price), -this.discount);
  }

  payProcess()
  {
    let order = new Orderdto();

    let id=new UserProfile()
    id = JSON.parse(localStorage.getItem("currentUser"))
    order.receiverId = id.id;

    let date=new Date().toISOString();
    order.date=date;

    order.foodDtoList=this.selectedItems;
    order.deliveryUserId=3;

    /// trebuie scos restaurant id dintr-o mancare

    order.restaurantId=this.selectedItems[0].restaurantId;

    console.log(order)

  }



}
