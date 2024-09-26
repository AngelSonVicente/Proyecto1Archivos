import { Component } from '@angular/core';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';

import { ProductoService } from 'src/services/ProductosService';


import { ProductosSucursalesService } from 'src/services/ProductosSucursalesService';
import { CarritoBodegaService } from 'src/app/Servicios/carrito-bodega.service';

@Component({
  selector: 'app-ingresar-productos-bodega',
  templateUrl: './ingresar-productos-bodega.component.html',
  styleUrls: ['./ingresar-productos-bodega.component.css']
})
export class IngresarProductosBodegaComponent {
  productos: Productos[] = [];

  usuario!:Usuario;

  constructor(private productoServiceBD: ProductoService, private porductosService: CarritoBodegaService) { 

    
  
  }

  ngOnInit(): void {

      
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    

    this.productoServiceBD.getProductos().subscribe({

      next: (list: Productos[]) => {
        this.productos = list;

        
      }
    });


  
  }

  agregarAlCarrito(producto: Productos): void {


    const cantidad = prompt(`Cuantos ${producto.nombre} deseas agregar?`, '1');

    if (cantidad && Number(cantidad) > 0) {
      const cantidadProductos = Number(cantidad);
      producto.existencias=cantidadProductos;
  
    } else {
      alert('Por favor, ingresa una cantidad valida.');
    }
    
    this.porductosService.agregarAlCarrito(producto);
    alert(`${producto.nombre} agregado al carrito!`);
  }



  
  refrescarPagina(): void {
    window.location.reload();
  }


}
