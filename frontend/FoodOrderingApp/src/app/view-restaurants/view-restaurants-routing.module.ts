import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ViewRestaurantsPage } from './view-restaurants.page';

const routes: Routes = [
  {
    path: '',
    component: ViewRestaurantsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ViewRestaurantsPageRoutingModule {}
