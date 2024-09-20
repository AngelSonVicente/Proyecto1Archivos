import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';





import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ModuloCajeroComponent } from './ModuloCajero/modulo-cajero/modulo-cajero.component';





@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    ModuloCajeroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
