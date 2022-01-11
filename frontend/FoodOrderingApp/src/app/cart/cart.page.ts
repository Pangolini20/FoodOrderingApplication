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
    // this.selectedItems = this.selectedItems.sort((a,b) => (a.restaurantName > b.restaurantName) ? 1 : ((b.restaurantName > a.restaurantName) ? -1 : 0))
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
    order.id=0
    let date=new Date().toISOString();
    order.date=date;
/////////////////////////////////////////////////////////////////////////////
    let contents = this.selectedItems;

    for(let i = 0;i < contents.length;i++)
      for(let j=0 ;j<contents[i].count;j++) {
        let foodDto = new FoodDto();
        foodDto.id=contents[i].id
        foodDto.price=contents[i].price
        foodDto.restaurantId=contents[i].restaurantId
        foodDto.name=contents[i].name
        foodDto.category=contents[i].category
        foodDto.description=contents[i].description
        order.foodDtoList.push(foodDto);
      }
////////////////////////////////////////////////////////////////////////
    order.deliveryUserId=3; //generic val we have no delivery boy :D

    /// trebuie scos restaurant id dintr-o mancare
    order.restaurantId=this.selectedItems[0].restaurantId;

    // console.log(order)

    this.cartService.currentOrder=order;
    console.log(this.cartService.currentOrder)
  }



}
