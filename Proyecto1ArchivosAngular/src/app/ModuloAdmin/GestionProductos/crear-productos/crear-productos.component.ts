import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/entities/Cliente';
import { Producto } from 'src/entities/Producto';
import { Productos } from 'src/entities/Productos';
import { ProductoService } from 'src/services/ProductosService';

@Component({
  selector: 'app-crear-productos',
  templateUrl: './crear-productos.component.html',
  styleUrls: ['./crear-productos.component.css']
})
export class CrearProductosComponent implements OnInit {



  FormularioProducto!: FormGroup;
  saved: boolean = false;

  error: boolean = false;
  UsuarioCreacion!: Cliente;
  codigoCreado!: string;
  producto!: Productos;




  constructor(private productosService: ProductoService, private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router) { }
  ngOnInit(): void {


    this.FormularioProducto = this.formBuilder.group({

      nombre: [null, [Validators.required]],

      descripcion: [null, [Validators.required]],
      categoria: [null, [Validators.required]],
      sub_categoria: [null, [Validators.required]],
      plataforma: [null, [Validators.required]]



    });



  }

  submit(): void {
    if (this.FormularioProducto.valid) {
      this.producto = this.FormularioProducto.value as Productos;


      this.productosService.crearProducto(this.producto).subscribe({
        next: (created: Productos) => {
          console.log("creado " + created);

          this.producto = created;
          this.saved = true;
          this.error = false;
          this.limpiar()
        },
        error: (error: any) => {
          console.log("error");
          this.error = true;
          this.saved = false

        }
      });
    }
  }
  limpiar(): void {
    this.FormularioProducto.reset({

    });

  }





}
