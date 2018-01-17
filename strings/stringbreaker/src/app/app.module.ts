import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {PanelModule} from 'primeng/components/panel/panel';
import {InputTextareaModule} from 'primeng/components/inputtextarea/inputtextarea';
import {ButtonModule} from 'primeng/components/button/button';
import {SpinnerModule} from 'primeng/components/spinner/spinner';
import {GrowlModule} from 'primeng/components/growl/growl';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';


@NgModule({
  declarations: [
      AppComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule, FormsModule, HttpClientModule,
    PanelModule, InputTextareaModule, ButtonModule, SpinnerModule, GrowlModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
