import { Component, OnInit } from '@angular/core';
import { SucursalesIngresos } from 'src/entities/SucursalesIngresos';
import { ReportesService } from 'src/services/ReportesService';

@Component({
  selector: 'app-reporte3',
  templateUrl: './reporte3.component.html',
  styleUrls: ['./reporte3.component.css']
})
export class Reporte3Component implements OnInit{

  sucursales!:SucursalesIngresos[];

  constructor(private reportesService: ReportesService){

  }
  ngOnInit(): void {
  
    this.reportesService.getReporte3().subscribe(data => {
      this.sucursales = data;
    });
  
  
  }



}
