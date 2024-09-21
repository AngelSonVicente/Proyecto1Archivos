import { Component, OnInit } from '@angular/core';
import { ProductoService } from 'src/app/Servicios/producto.service';
import { Producto } from 'src/entities/Producto';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];


  constructor(private productoService: ProductoService) { 
    
  
  }

  ngOnInit(): void {
    this.productos = this.productoService.obtenerProductos();

    
  
  }

  agregarAlCarrito(producto: Producto): void {
    this.productoService.agregarAlCarrito(producto);
    alert(`${producto.nombre} agregado al carrito!`);
  }

}
