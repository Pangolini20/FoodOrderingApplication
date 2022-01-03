import { Component, OnInit } from '@angular/core';
import {MenuController} from "@ionic/angular";

@Component({
  selector: 'app-discount-codes',
  templateUrl: './discount-codes.page.html',
  styleUrls: ['./discount-codes.page.scss'],
})
export class DiscountCodesPage implements OnInit {

  constructor(private menu:MenuController) { }

  ngOnInit() {
  }
  _openMenuClient(){
    this.menu.enable(true, 'main');
    this.menu.open('main');
  }

}
