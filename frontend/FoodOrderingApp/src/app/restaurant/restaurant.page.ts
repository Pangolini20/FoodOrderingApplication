import { Component, OnInit } from '@angular/core';
import {CartService} from "../Providers/cart.service";
import {Router} from "@angular/router";
import {FoodService} from "../services/food.service";
import {FoodDto} from "../dto/food-dto";

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.page.html',
  styleUrls: ['./restaurant.page.scss'],
})
export class RestaurantPage implements OnInit {
  cart = [];
  items = [];

  foodList:FoodDto[];


  sliderConfig = {
    slidesPerView: 1.6,
    spaceBetween: 10,
    centeredSlides: true
  };
  constructor(private router: Router,
              private cartService: CartService,
              private foodService:FoodService) {

    this.foodService.getFoodByRestaurantId(this.router.getCurrentNavigation().extras.state.data)
      .subscribe(foodList => {this.foodList=foodList
      console.log(this.foodList)});

  }



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
