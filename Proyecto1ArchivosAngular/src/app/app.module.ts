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
import { RealizarVentaComponent } from './ModuloCajero/realizar-venta/realizar-venta.component';
import { ProductosComponent } from './ModuloCajero/productos/productos.component';
import { CarritoComponent } from './ModuloCajero/carrito/carrito.component';
import { CrearClienteComponent } from './ModuloCajero/crear-cliente/crear-cliente.component';
import { ModuloAdminComponent } from './ModuloAdmin/modulo-admin/modulo-admin.component';
import { ProductosExistentesComponent } from './ModuloAdmin/GestionProductos/productos-existentes/productos-existentes.component';
import { CrearProductosComponent } from './ModuloAdmin/GestionProductos/crear-productos/crear-productos.component';
import { CrearEmpleadosComponent } from './ModuloAdmin/GestionEmpleados/crear-empleados/crear-empleados.component';





@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    ModuloCajeroComponent,
    RealizarVentaComponent,
    ProductosComponent,
    CarritoComponent,
    CrearClienteComponent,
    ModuloAdminComponent,
    ProductosExistentesComponent,
    CrearProductosComponent,
    CrearEmpleadosComponent
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
