import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-view-food',
  templateUrl: './view-food.page.html',
  styleUrls: ['./view-food.page.scss'],
})
export class ViewFoodPage implements OnInit {

  constructor(private menu:MenuController) { }

  ngOnInit() {
  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }
}
