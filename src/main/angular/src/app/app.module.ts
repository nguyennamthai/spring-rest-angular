import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {MaterialModule} from "./material.module";
import {SignupComponent} from './auth/signup/signup.component';
import {LoginComponent} from './auth/login/login.component';
import {HomeComponent} from './home/home.component';
import {MessageAddComponent} from './message/message-add/message-add.component';
import {MessageEditComponent} from './message/message-edit/message-edit.component';
import {MessageListComponent} from './message/message-list/message-list.component';
import {MessageDetailComponent} from './message/message-detail/message-detail.component';
import {HeaderComponent} from './header/header.component';
import {UserDetailComponent} from './user/user-detail/user-detail.component';
import {UserListComponent} from './user/user-list/user-list.component';
import {UserEditComponent} from './user/user-edit/user-edit.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    MessageAddComponent,
    MessageEditComponent,
    MessageListComponent,
    MessageDetailComponent,
    HeaderComponent,
    UserDetailComponent,
    UserListComponent,
    UserEditComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    MaterialModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
