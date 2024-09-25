import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bodega } from 'src/entities/Bodega';
import { Cliente } from 'src/entities/Cliente';
import { Productos } from 'src/entities/Productos';
import { Sucursal } from 'src/entities/Sucursal';
import { Usuario } from 'src/entities/Usuario';
import { BodegaService } from 'src/services/BodegaService';
import { ProductoService } from 'src/services/ProductosService';
import { SucursalService } from 'src/services/SucursalService';
import { UsuarioService } from 'src/services/UsuarioService';

@Component({
  selector: 'app-crear-empleados',
  templateUrl: './crear-empleados.component.html',
  styleUrls: ['./crear-empleados.component.css']
})
export class CrearEmpleadosComponent implements OnInit {




  FormularioProducto!: FormGroup;
  saved: boolean = false;

  error: boolean = false;
  
  codigoCreado!: string;
  producto!: Productos;

  sucursales!: Sucursal[];
  bodegas!: Bodega[];

  usuarioCreacion!:Usuario;





  constructor(private productosService: ProductoService, private formBuilder: FormBuilder,
    private route: ActivatedRoute, private router: Router, private sucursalesService: SucursalService,
    private bodegaService: BodegaService, private usuarioService:UsuarioService

  ) { }
  ngOnInit(): void {






    this.FormularioProducto = this.formBuilder.group({

      nombre: [null, [Validators.required]],

      usuario: [null, [Validators.required]],
      correo: [null, [Validators.required]],
      password: [null, [Validators.required]],
      tipo: [null, [Validators.required]],



      codigoSucursal: [null, ],
      codigoBodega: [null, ],
      codigoCaja: [null, ]


    });



    this.sucursalesService.getSucursales().subscribe({

      next: (list: Sucursal[]) => {
        this.sucursales = list;


      }
    });




    this.bodegaService.getBodegas().subscribe({

      next: (list: Bodega[]) => {
        this.bodegas = list;
        console.log(list)
      }
    });


    



  }

  submit(): void {
    if (this.FormularioProducto.valid) {
      this.usuarioCreacion = this.FormularioProducto.value as Usuario;


      this.usuarioService.crearUsuario(this.usuarioCreacion).subscribe({
        next: (created: Usuario) => {
          console.log("creado " + created);

          this.usuarioCreacion = created;
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
