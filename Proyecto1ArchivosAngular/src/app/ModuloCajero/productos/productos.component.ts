import { Component, OnInit } from '@angular/core';
import { ProductoService } from 'src/app/Servicios/producto.service';
import { Producto } from 'src/entities/Producto';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';
import { ProductosSucursalesService } from 'src/services/ProductosSucursalesService';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  productos: Productos[] = [];

  usuario!:Usuario;

  constructor(private productoService: ProductoService, private productosSucursal:ProductosSucursalesService) { 
    
  
  }

  ngOnInit(): void {

      
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    

    this.productosSucursal.getProductosSucursal(this.usuario.codigoSucursal).subscribe({

      next: (list: Productos[]) => {
        this.productos = list;

        
      }
    });


  
  }

  agregarAlCarrito(producto: Productos): void {
    this.productoService.agregarAlCarrito(producto);
    alert(`${producto.nombre} agregado al carrito!`);
  }

}
