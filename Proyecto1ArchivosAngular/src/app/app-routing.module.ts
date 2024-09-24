import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { ModuloCajeroComponent } from './ModuloCajero/modulo-cajero/modulo-cajero.component';
import { RealizarVentaComponent } from './ModuloCajero/realizar-venta/realizar-venta.component';
import { ProductosComponent } from './ModuloCajero/productos/productos.component';
import { CarritoComponent } from './ModuloCajero/carrito/carrito.component';
import { CrearClienteComponent } from './ModuloCajero/crear-cliente/crear-cliente.component';

const rutasCajero = [
  {
    path: 'Ventas',
    title: 'Realizar Centa',
    component: RealizarVentaComponent
  },

  {
    path: 'Productos',
    title: 'Productos',
    component: ProductosComponent
  },
  {
    path: 'Carrito',
    title: 'Carrito',
    component: CarritoComponent
  },
  {
    path: 'CrearCliente',
    title: 'Crear Usuario',
    component: CrearClienteComponent
  },



]

const routes: Routes = [
  {
    path: "",
    redirectTo: "/Proyecto1/Menu",
    pathMatch: "full"
  },
  {
    path: "Proyecto1/Menu",
    title: "Menu",
    component: MenuComponent
  },
  {
    path: 'Proyecto1/login/:userRole',
    title: "Login",
    component: LoginComponent 
  },
  {
    path: 'Proyecto1/Modulo/Cajero',
    title: "Modulo Cajero",
    component: ModuloCajeroComponent 
  },
  {
    path:"Proyecto1/Cajero",
    title:"Usuario",
    children: rutasCajero,
  
  },
  



];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
