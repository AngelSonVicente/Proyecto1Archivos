import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/entities/Cliente';
import { ClienteService } from 'src/services/ClienteService';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {

  
  FormularioCliente!: FormGroup;
  saved : boolean=false;

  error: boolean = false;
  UsuarioCreacion!:Cliente;
  codigoCreado!:string;

  

  constructor(private clieenteService: ClienteService, private formBuilder: FormBuilder, private route: ActivatedRoute,  private router: Router) { }
  ngOnInit(): void {
   
    
    this.FormularioCliente = this.formBuilder.group({
      nit: [null, [Validators.required]],
      nombre: [null, [Validators.required, Validators.maxLength(100)]],
      
      direccion: [null, [Validators.required,Validators.maxLength(200)]],
      correo: [null, [Validators.required, Validators.maxLength(100)]],
      
      

    });

 

  }

  submit(): void {
    if (this.FormularioCliente.valid) {
      this.UsuarioCreacion = this.FormularioCliente.value as Cliente;

    
      this.clieenteService.crearCliente(this.UsuarioCreacion).subscribe({
        next: (created: Cliente) => {
          console.log("creado " + created);
         
          this.saved = true;
          this.error=false;
          this.limpiar()
        },
        error: (error: any) => {
          console.log("error");
          this.error=true;
          this.saved=false

        }
      });
    }
  }
  limpiar(): void {
    this.FormularioCliente.reset({

    });

  }




}
