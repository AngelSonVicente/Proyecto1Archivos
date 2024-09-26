import { Component, OnInit } from '@angular/core';
import { ProductosVendidos } from 'src/entities/ProductosVendidos';
import { SucursalesIngresos } from 'src/entities/SucursalesIngresos';
import { ReportesService } from 'src/services/ReportesService';

@Component({
  selector: 'app-reporte4',
  templateUrl: './reporte4.component.html',
  styleUrls: ['./reporte4.component.css']
})

export class Reporte4Component implements OnInit{

  

  reportes!:ProductosVendidos[];

  constructor(private reportesService: ReportesService){

  }
  ngOnInit(): void {
  
    this.reportesService.getReporte4().subscribe(data => {
      this.reportes = data;
    });
  
  
  }

}
