import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-view-restaurants',
  templateUrl: './view-restaurants.page.html',
  styleUrls: ['./view-restaurants.page.scss'],
})
export class ViewRestaurantsPage implements OnInit {

  constructor(private menu:MenuController) { }

  ngOnInit() {
  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }
}
