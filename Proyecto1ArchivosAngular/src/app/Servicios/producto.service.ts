import { Injectable } from '@angular/core';
import { Producto } from 'src/entities/Producto';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private productos: Producto[] = [
    { id: 1, nombre: 'Producto 1', descripcion: 'Descripción del producto 1', precio: 100 },
    { id: 2, nombre: 'Producto 2', descripcion: 'Descripción del producto 2', precio: 150 },
    // Agrega más productos aquí
  ];

  constructor() { }
  private carritoSubject = new BehaviorSubject<Producto[]>([]);
  carrito$ = this.carritoSubject.asObservable();

  obtenerProductos(): Producto[] {
    return this.productos;
  }

  agregarAlCarrito(producto: Producto): void {
    const currentCarrito = this.carritoSubject.getValue();
    this.carritoSubject.next([...currentCarrito, producto]); // Añade el nuevo producto y emite el cambio
  }

  eliminarDelCarrito(productoId: number): void {
    const currentCarrito = this.carritoSubject.getValue();
    const updatedCarrito = currentCarrito.filter((producto: { id: number; }) => producto.id !== productoId);
    this.carritoSubject.next(updatedCarrito); // Emite el carrito actualizado
  }

  limpiarCarrito(): void {
    this.carritoSubject.next([]); // Limpia el carrito y emite el cambio
  }


}
