import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Productos } from 'src/entities/Productos';
import { Usuario } from 'src/entities/Usuario';
import { InventarioService } from 'src/services/InvetanrioService';
import { ProductoService } from 'src/services/ProductosService';
import { ProductosSucursalesService } from 'src/services/ProductosSucursalesService';

@Component({
  selector: 'app-actualizar-precio-pasillo',
  templateUrl: './actualizar-precio-pasillo.component.html',
  styleUrls: ['./actualizar-precio-pasillo.component.css']
})
export class ActualizarPrecioPasilloComponent {

  
  productos !:Productos[];

  usuario!:Usuario;

  constructor(private productosService : ProductosSucursalesService, private router: Router){}
 

  ngOnInit(): void {
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;   

    
    this.productosService.getProductosSucursal(this.usuario.codigoSucursal).subscribe({

      next: (list: Productos[]) => {
        this.productos = list;

        
      }
    });
  
  }


  actualizar(producto: Productos): void {
    // Navegar al nuevo componente pasando el objeto "producto" en el estado
    this.router.navigate(['/Proyecto1/Inventario/AsignarPrecioPasillo'], { state: { producto } });
  }


}
