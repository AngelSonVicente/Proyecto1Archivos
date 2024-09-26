import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { CarritoComponent } from 'src/app/ModuloCajero/carrito/carrito.component';
import { Cliente } from 'src/entities/Cliente';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';
import { Venta } from 'src/entities/Venta';
import { ClienteService } from 'src/services/ClienteService';
import { VentaSerivice } from 'src/services/VentaService';
import { ProductoService } from 'src/app/Servicios/producto.service';
import { CarritoBodegaService } from 'src/app/Servicios/carrito-bodega.service';
import { ProductosBodega } from 'src/entities/ProductosBodega';
import { ProductosBodegaService } from 'src/services/ProductosBodegaService';

@Component({
  selector: 'app-carrito-ingreso-bodega',
  templateUrl: './carrito-ingreso-bodega.component.html',
  styleUrls: ['./carrito-ingreso-bodega.component.css']
})
export class CarritoIngresoBodegaComponent implements OnInit {
  @ViewChild(CarritoComponent) carritoComponent!: CarritoComponent;

  usuario!: Usuario;

  codigoFact!: number;
  venta!: Venta;


  error: boolean = false;
  creado: boolean = false;

  puntosAUsar: number = 0;
  nitValido: boolean = false;



  cliente!: Cliente;
  carrito: Productos[] = [];
  total: number = 0;

  pagoEfectivo: boolean = true;
  FormularioTarjeta!: FormGroup;
  FormularioNit!: FormGroup;
  CF: boolean = true;
  productosBodega!: ProductosBodega;



  carritoSubscription!: Subscription;

  constructor(private carritoService: CarritoBodegaService, private formBuilder: FormBuilder,

    private productosBodegaServie: ProductosBodegaService
  ) {

    this.productosBodega = new ProductosBodega();

  }


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


    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario = jsonUsuario ? JSON.parse(jsonUsuario) : null;

    // Nos suscribimos al carrito para obtener actualizaciones en tiempo real
    this.carritoSubscription = this.carritoService.carrito$.subscribe((productos) => {
      this.carrito = productos;
   
    });








  }

  eliminarDelCarrito(productoId: number): void {
    this.carritoService.eliminarDelCarrito(productoId);
 
  }



  
  finalizarCompra(): void {



    this.productosBodega.codigoBodega = this.usuario.codigoBodega;
    this.productosBodega.productos = this.carrito;


    this.productosBodegaServie.ingresarProductos(this.productosBodega).subscribe(
      venta => {

        this.error = false;
        this.creado = true;



        this.carrito =[];
        this.carritoService.limpiarCarrito();
       
        
        alert(`Se han ingresado todos los productos satisfactoriamente!`);

       
        
        
        

      },
      error => {
        console.log('Error: ', error);

        this.error = true;
        this.creado = false;



      }
    );










  }







}
