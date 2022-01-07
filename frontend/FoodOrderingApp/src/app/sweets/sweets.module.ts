import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SweetsPageRoutingModule } from './sweets-routing.module';

import { SweetsPage } from './sweets.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    SweetsPageRoutingModule
  ],
  declarations: [SweetsPage]
})
export class SweetsPageModule {}
