import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuForClientComponent } from "./Components/menu-for-client/menu-for-client.component";

import { HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [AppComponent, MenuForClientComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, HttpClientModule],
  providers: [{provide: RouteReuseStrategy, useClass: IonicRouteStrategy}],
  bootstrap: [AppComponent],

  exports: [
    MenuForClientComponent]
})
export class AppModule {}
