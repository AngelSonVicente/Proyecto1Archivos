import { Component } from '@angular/core';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';

import { ProductoService } from 'src/services/ProductosService';


import { ProductosSucursalesService } from 'src/services/ProductosSucursalesService';
import { CarritoBodegaService } from 'src/app/Servicios/carrito-bodega.service';
import { ProductosBodegaService } from 'src/services/ProductosBodegaService';

@Component({
  selector: 'app-enviar-productos-sucursal',
  templateUrl: './enviar-productos-sucursal.component.html',
  styleUrls: ['./enviar-productos-sucursal.component.css']
})
export class EnviarProductosSucursalComponent {


  productos: Productos[] = [];

  usuario!: Usuario;
  existenciasAnterior: number = 0;

  constructor(private productoServiceBD: ProductosBodegaService, private porductosService: CarritoBodegaService) {



  }

  ngOnInit(): void {


    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario = jsonUsuario ? JSON.parse(jsonUsuario) : null;

    this.productoServiceBD.getProductosBodegas(this.usuario.codigoBodega).subscribe({

      next: (list: Productos[]) => {
        this.productos = list;


      }
    });



  }

  agregarAlCarrito(producto: Productos): void {

    this.existenciasAnterior = producto.existencias;

    const cantidad = prompt(`Cuantos ${producto.nombre} deseas agregar?`, '1');


    if (cantidad && Number(cantidad) > 0) {
      const cantidadProductos = Number(cantidad);
      producto.existencias = cantidadProductos;

      const productoCopia = Object.assign({}, producto);

      // Pasar "productoCopia" al carrito
      this.porductosService.agregarAlCarrito(productoCopia);


      alert(`${producto.nombre} agregado al carrito!`);



    } else {
      alert('Por favor, ingresa una cantidad valida.');
    }


    producto.existencias = this.existenciasAnterior - Number(cantidad);


  }




  refrescarPagina(): void {
    window.location.reload();
  }





}
