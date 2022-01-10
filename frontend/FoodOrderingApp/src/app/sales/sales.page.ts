import {Component, OnInit} from '@angular/core';
import {MenuController} from "@ionic/angular";
import {CodeDto} from "../dto/code-dto";
import {RestaurantDto} from "../dto/restaurant-dto";
import {RestaurantService} from "../services/restaurant.service";
import {UserProfile} from "../dto/user-profile";
import {CodeDetails} from "../dto/code-details";
import {CodeService} from "../services/code.service";

@Component({
  selector: 'app-sales',
  templateUrl: './sales.page.html',
  styleUrls: ['./sales.page.scss'],
})
export class SalesPage implements OnInit {

  name:string;
  percentage:number;
  restaurantList?:RestaurantDto[];
  restaurantId:number;
  ownerProfile:UserProfile = JSON.parse(localStorage.getItem("currentUser"));
  expirationDate:string;
  codesList?:CodeDto[];
  restaurantId2:number;

  constructor(private menu:MenuController,
              private restaurantService:RestaurantService,
              private codeService:CodeService) {
    this.restaurantService.getRestaurantsByOwnerId(this.ownerProfile.id).subscribe(x =>this.restaurantList = x);
  }

  create()
  {
    let code = new CodeDetails();

    code.name = this.name;
    code.value = this.percentage;
    code.expirationDate = this.expirationDate;

    this.codeService.createCode(this.restaurantId,code).subscribe();

  }

  onChange()
  {
    this.codeService.getDiscountCodes(this.restaurantId2).subscribe(x => this.codesList = x);
  }

  delete(codeId:number)
  {
     this.codeService.deleteCode(codeId).subscribe()
  }

  ngOnInit() {

  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }
}
