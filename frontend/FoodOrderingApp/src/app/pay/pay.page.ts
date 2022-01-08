import { Component, OnInit } from '@angular/core';
import {CartService} from "../Providers/cart.service";
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.page.html',
  styleUrls: ['./pay.page.scss'],
})
export class PayPage implements OnInit {

  input:number;
  constructor(private cartService: CartService, public alertController: AlertController) { }
  selectedItems = [];
  total=0;

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
    this.total = this.selectedItems.reduce((a, b) => a + (b.count * b.price), 0);

  }

  showAlert() {

    this.alertController.create({
      header: 'Order Confirmation',
      subHeader: '',
      message: 'Your food will be there very soon!',
      cssClass:'buttonCss',
      buttons: ['OK']
    }).then(res => {

      res.present();

    });

  }

}


