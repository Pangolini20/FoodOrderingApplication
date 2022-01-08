import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ViewRestaurantsPageRoutingModule } from './view-restaurants-routing.module';

import { ViewRestaurantsPage } from './view-restaurants.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ViewRestaurantsPageRoutingModule
  ],
  declarations: [ViewRestaurantsPage]
})
export class ViewRestaurantsPageModule {}
