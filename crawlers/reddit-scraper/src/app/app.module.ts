import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {PanelModule} from "primeng/components/panel/panel";
import {ButtonModule} from "primeng/components/button/button";
import {DataListModule} from "primeng/components/datalist/datalist";
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {ThreadService} from "./service/thread-service";


@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule, BrowserAnimationsModule,
        PanelModule, ButtonModule, DataListModule,
        HttpClientModule, FormsModule
    ],
    providers: [ThreadService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
