import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SweetsPage } from './sweets.page';

const routes: Routes = [
  {
    path: '',
    component: SweetsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SweetsPageRoutingModule {}
