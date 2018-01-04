import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Service} from './service/robot.service'

import {AppComponent} from './app.component';
import {LogComponent} from './log/log.component'
import {ActionComponent} from './action/action.component'
import {HttpClientModule} from "@angular/common/http";
import {StompService} from "@stomp/ng2-stompjs";

@NgModule({
  declarations: [
    AppComponent,
    LogComponent,
    ActionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [Service, StompService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
