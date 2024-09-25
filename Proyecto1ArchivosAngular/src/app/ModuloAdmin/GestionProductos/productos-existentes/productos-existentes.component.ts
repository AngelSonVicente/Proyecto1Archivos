import { Component, OnInit } from '@angular/core';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';
import { ProductoService } from 'src/services/ProductosService';

@Component({
  selector: 'app-productos-existentes',
  templateUrl: './productos-existentes.component.html',
  styleUrls: ['./productos-existentes.component.css']
})
export class ProductosExistentesComponent implements OnInit{

  productos !:Productos[];

  usuario!:Usuario;

  constructor(private productosService : ProductoService){}
 

  ngOnInit(): void {
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;   

    
    this.productosService.getProductos().subscribe({

      next: (list: Productos[]) => {
        this.productos = list;

        
      }
    });
  
  }





}
