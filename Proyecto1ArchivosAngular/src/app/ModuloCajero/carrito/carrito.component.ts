import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ProductoService } from 'src/app/Servicios/producto.service';
import { Cliente } from 'src/entities/Cliente';
import { Producto } from 'src/entities/Producto';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';
import { Venta } from 'src/entities/Venta';
import { ClienteService } from 'src/services/ClienteService';
import { VentaSerivice } from 'src/services/VentaService';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {
  @ViewChild(CarritoComponent) carritoComponent!: CarritoComponent;

  usuario!:Usuario;

  venta!:Venta;

  puntosAUsar:number=0;
  nitValido:boolean=false;

  clienteSinUsuario:boolean=false;
  clienteNull!:Cliente;
  cliente!:Cliente;
  carrito: Productos[] = [];
  total: number = 0;

  pagoEfectivo:boolean=true;
  FormularioTarjeta!: FormGroup;
  FormularioNit!: FormGroup;

  CF:boolean=true;


  carritoSubscription!: Subscription;

  constructor(private productoService: ProductoService,private formBuilder: FormBuilder,
              private clienteService:ClienteService, private ventaService:VentaSerivice
  ) { 


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
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    

     // Nos suscribimos al carrito para obtener actualizaciones en tiempo real
     this.carritoSubscription = this.productoService.carrito$.subscribe((productos) => {
      this.carrito = productos;
      this.calcularTotal();
    });


    this.FormularioTarjeta = this.formBuilder.group({
   
      
      numeroTarjeta: [null, [Validators.required]],
      codigoSeguridad: [null, [Validators.required, Validators.maxLength(3)]],
    

    });
    this.FormularioNit = this.formBuilder.group({
   
      
      nitCliente: [null, [Validators.required]],
      
      

    });




  }

  eliminarDelCarrito(productoId: number): void {
    this.productoService.eliminarDelCarrito(productoId);   
    this.calcularTotal();
  }



  calcularTotal(): void {
    this.total = this.carrito.reduce((acc, producto) => acc + producto.precio, 0);
  }

  finalizarCompra(): void {
    this.venta = this.FormularioNit.value as Venta;

 
 
    this.venta.puntosUsados=this.puntosAUsar;
    this.venta.codigoCajero=this.usuario.codigo;
    this.venta.nitCliente=this.FormularioNit.get("nitCliente")?.value;
    this.venta.productos=this.carrito;
    this.venta.codigoSucursal=this.usuario.codigoSucursal;

    this.ventaService.logear(this.venta).subscribe(
      venta => {


      },
      error => {
        console.log('Error: ', error);
     
      }
    );

    
    



    this.productoService.limpiarCarrito();
 
 
 
    this.carrito = [];
    this.total = 0;

    
    alert(`Compra realizada! Total: Q${this.total}`);
 
  }

  efectivo(){
    this.pagoEfectivo=true;

  }
  tarjeta(){
    this.pagoEfectivo=false;
  }
  cF(){
    this.CF=true;
    this.nitValido=true;
  }
  nit(){
    this.CF=false;
  }

  buscarCliente(){

   this.cliente= this.clienteNull;
    
    this.clienteService.getCLiente(this.FormularioNit.get("nitCliente")?.value).subscribe({

      next: (clienteBD: Cliente) => {
        this.cliente = clienteBD;

      
        this.clienteSinUsuario=false;
        this.nitValido=true;
        
      },
      error: (error: any) => {
        this.clienteSinUsuario=true;
        this.nitValido=false;
      }
    });

    
  }


}
