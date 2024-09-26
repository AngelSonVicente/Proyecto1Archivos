import { Injectable } from '@angular/core';
import { Producto } from 'src/entities/Producto';
import { BehaviorSubject } from 'rxjs';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';
import { ProductosSucursalesService } from 'src/services/ProductosSucursalesService';

@Injectable({
  providedIn: 'root'
})
export class CarritoBodegaService {

  
  
  
  constructor() {

    
   }


   



 
  private carritoSubject = new BehaviorSubject<Productos[]>([]);
  carrito$ = this.carritoSubject.asObservable();


  agregarAlCarrito(producto: Productos): void {
    const currentCarrito = this.carritoSubject.getValue();
    this.carritoSubject.next([...currentCarrito, producto]); // Añade el nuevo producto y emite el cambio
  }

  eliminarDelCarrito(productoId: number): void {
    const currentCarrito = this.carritoSubject.getValue();
    const updatedCarrito = currentCarrito.filter((producto: { codigoProducto: number; }) => producto.codigoProducto !== productoId);
    this.carritoSubject.next(updatedCarrito); // Emite el carrito actualizado
  }
  

  limpiarCarrito(): void {
    this.carritoSubject.next([]); // Limpia el carrito y emite el cambio
  }


}
