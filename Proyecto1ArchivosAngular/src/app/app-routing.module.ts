import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { ModuloCajeroComponent } from './ModuloCajero/modulo-cajero/modulo-cajero.component';
import { RealizarVentaComponent } from './ModuloCajero/realizar-venta/realizar-venta.component';
import { ProductosComponent } from './ModuloCajero/productos/productos.component';
import { CarritoComponent } from './ModuloCajero/carrito/carrito.component';
import { CrearClienteComponent } from './ModuloCajero/crear-cliente/crear-cliente.component';
import { ModuloAdminComponent } from './ModuloAdmin/modulo-admin/modulo-admin.component';
import { ProductosExistentesComponent } from './ModuloAdmin/GestionProductos/productos-existentes/productos-existentes.component';
import { CrearProductosComponent } from './ModuloAdmin/GestionProductos/crear-productos/crear-productos.component';
import { CrearEmpleadosComponent } from './ModuloAdmin/GestionEmpleados/crear-empleados/crear-empleados.component';
import { ModuloBodegaComponent } from './ModuloBodega/modulo-bodega/modulo-bodega.component';
import { IngresarProductosBodegaComponent } from './ModuloBodega/IngresarProductos/ingresar-productos-bodega/ingresar-productos-bodega.component';
import { EnviarProductosSucursalComponent } from './ModuloBodega/EnviarProductos/enviar-productos-sucursal/enviar-productos-sucursal.component';
import { ModuloInventarioComponent } from './ModuloInventario/modulo-inventario/modulo-inventario.component';
import { ProductosPendientesComponent } from './ModuloInventario/AsginacionPrecioPasillo/productos-pendientes/productos-pendientes.component';
import { AsignarPrecioPasilloComponent } from './ModuloInventario/AsginacionPrecioPasillo/asignar-precio-pasillo/asignar-precio-pasillo.component';
import { ActualizarPrecioPasilloComponent } from './ModuloInventario/ActualizarPrecioPasillo/actualizar-precio-pasillo/actualizar-precio-pasillo.component';
import { ReportesComponent } from './ModuloAdmin/Reportes/reportes/reportes.component';

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
const rutasBodega = [
  {
    path: 'IngresarProductosBodega',
    title: 'Ingresar productos a bodega',
    component: IngresarProductosBodegaComponent
  },
  {
    path: 'EnviarProductosSucursal',
    title: 'Enviar productos a Sucursal',
    component: EnviarProductosSucursalComponent
  },

 
]
const rutasInventario = [
  {
    path: 'ProductosPendientes',
    title: 'Productos Pendientes',
    component: ProductosPendientesComponent
  },
  {
    path: 'AsignarPrecioPasillo',
    title: 'Asignar Precio',
    component: AsignarPrecioPasilloComponent
  },
  {
    path: 'ActualizarPrecioPasillo',
    title: 'Actualizar Precio ',
    component: ActualizarPrecioPasilloComponent
  },

  
 
]




const rutasAdmin = [

  {
    path: 'GestionProductos',
    title: 'Gestion Productos',
    component: ProductosExistentesComponent
  },
  {
    path: 'CrearProducto',
    title: 'Crear Producto',
    component: CrearProductosComponent
  },
  {
    path: 'CrearEmpleado',
    title: 'Crear Empleados',
    component: CrearEmpleadosComponent
  },
  {
    path: 'Reportes',
    title: 'Reportes',
    component: ReportesComponent
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
    path: 'Proyecto1/Modulo/Administrador',
    title: "Modulo Administrador",
    component: ModuloAdminComponent 
  },
  {
    path: 'Proyecto1/Modulo/Bodega',
    title: "Modulo Bodega",
    component: ModuloBodegaComponent 
  },
  {
    path: 'Proyecto1/Modulo/Inventario',
    title: "Modulo Inventario",
    component: ModuloInventarioComponent 
  },

  {
    path:"Proyecto1/Bodega",
    title:"Bodega",
    children: rutasBodega,
  
  },
  {
    path:"Proyecto1/Cajero",
    title:"Usuario",
    children: rutasCajero,
  
  },
  {
    path:"Proyecto1/Administrador",
    title:"Administrador",
    children: rutasAdmin,
  
  },
  {
    path:"Proyecto1/Inventario",
    title:"Inventario",
    children: rutasInventario,
  
  },
  



];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
