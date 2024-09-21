import { Component, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { ProductoService } from 'src/app/Servicios/producto.service';
import { Producto } from 'src/entities/Producto';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {
  @ViewChild(CarritoComponent) carritoComponent!: CarritoComponent;

  carrito: Producto[] = [];
  total: number = 0;

  carritoSubscription!: Subscription;

  constructor(private productoService: ProductoService) { }


  ngAfterViewInit() {
    const modalElement = document.getElementById('exampleModal');
    if (modalElement) {
      modalElement.addEventListener('shown.bs.modal', () => {
        this.actualizarCarrito();
      });
    }
  }

  actualizarCarrito(): void {
    this.carritoComponent.ngOnInit();  // Llama a ngOnInit para recalcular el total y actualizar el carrito
  }


  ngOnInit(): void {

     // Nos suscribimos al carrito para obtener actualizaciones en tiempo real
     this.carritoSubscription = this.productoService.carrito$.subscribe((productos) => {
      this.carrito = productos;
      this.calcularTotal();
    });


  }



  calcularTotal(): void {
    this.total = this.carrito.reduce((acc, producto) => acc + producto.precio, 0);
  }

  finalizarCompra(): void {
    alert(`Compra realizada! Total: $${this.total}`);
    this.productoService.limpiarCarrito();
    this.carrito = [];
    this.total = 0;
  }

}
