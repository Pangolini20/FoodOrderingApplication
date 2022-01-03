import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.page.html',
  styleUrls: ['./add-food.page.scss'],
})
export class AddFoodPage implements OnInit {

  constructor(private menu:MenuController) { }

  ngOnInit() {
  }

  _openMenuAdmin(){
    this.menu.enable(true, 'second');
    this.menu.open('second');
  }
}
