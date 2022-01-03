import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.page.html',
  styleUrls: ['./orders.page.scss'],
})
export class OrdersPage implements OnInit {

  constructor(private menu:MenuController) { }

  ngOnInit() {
  }
  _openMenuClient(){
    this.menu.enable(true, 'main');
    this.menu.open('main');
  }
}
