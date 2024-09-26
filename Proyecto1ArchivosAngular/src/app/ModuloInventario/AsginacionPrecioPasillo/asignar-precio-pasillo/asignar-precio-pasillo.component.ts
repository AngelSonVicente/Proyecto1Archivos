import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Productos } from 'src/entities/Productos';
import { ProductosSinPrecio } from 'src/entities/ProductoSinPrecio';
import { Usuario } from 'src/entities/Usuario';
import { InventarioService } from 'src/services/InvetanrioService';

@Component({
  selector: 'app-asignar-precio-pasillo',
  templateUrl: './asignar-precio-pasillo.component.html',
  styleUrls: ['./asignar-precio-pasillo.component.css']
})
export class AsignarPrecioPasilloComponent implements OnInit {

  
  producto!:Productos;
  FormularioProducto!: FormGroup;
  productoActualizacion!:ProductosSinPrecio;
  error:boolean=false;
  actualizado:boolean=false;
  
  usuario!:Usuario;

  constructor(private formBuilder: FormBuilder, private inventarioService: InventarioService){}

  ngOnInit(): void {

    this.producto = history.state.producto;

    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    


    this.FormularioProducto = this.formBuilder.group({
   
      
      precio: [null, [Validators.required]],
      pasillo: [null, [Validators.required, Validators.maxLength(3)]],
    

    });
  
  }
submit(){

  this.productoActualizacion = this.FormularioProducto.value as ProductosSinPrecio;

  this.productoActualizacion.codigoProducto=this.producto.codigoProducto;
  this.productoActualizacion.codigoSucursal=this.usuario.codigoSucursal;
 
 
  
  
  this.inventarioService.actualizarPrecioPasillo(this.productoActualizacion).subscribe(
    venta => {

     this.error=false;
     this.actualizado=true;

   
     



     


    },
    error => {
      console.log('Error: ', error);

      this.error=true;
      this.actualizado=false;

    
      
    }
  );

  


}


}
