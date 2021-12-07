import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BrowsePageRoutingModule } from './browse-routing.module';

import { BrowsePage } from './browse.page';
import {SearchbarModule} from "../Components/searchbar/searchbar.module";
import {CategoryItemModule} from "../Components/category-item/category-item.module";


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BrowsePageRoutingModule,
    SearchbarModule,
    CategoryItemModule,
  ],
  declarations: [BrowsePage]
})
export class BrowsePageModule {}
