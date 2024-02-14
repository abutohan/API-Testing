import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MenuCardComponent } from './components/menu-card/menu-card.component';
import { HeaderComponent } from './components/header/header.component';
import { CapitalizeFirstPipe } from './pipes/capitalize-first';
import { FormatPricePipe } from './pipes/format-price.pipe';
import { NoImageDirective } from './directives/no-image.directive';

@NgModule({
  declarations: [
    AppComponent,
    MenuCardComponent,
    HeaderComponent,
    CapitalizeFirstPipe,
    FormatPricePipe,
    NoImageDirective,
  ],
  imports: [BrowserModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
