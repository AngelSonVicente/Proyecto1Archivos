import { Component, OnInit } from '@angular/core';
import { ClientesGastados } from 'src/entities/ClientesGastados';
import { ProductosVendidos } from 'src/entities/ProductosVendidos';
import { ReportesService } from 'src/services/ReportesService';

@Component({
  selector: 'app-reporte5',
  templateUrl: './reporte5.component.html',
  styleUrls: ['./reporte5.component.css']
})
export class Reporte5Component implements OnInit{
  

  

  reportes!:ClientesGastados[];

  constructor(private reportesService: ReportesService){

  }
  ngOnInit(): void {
  
    this.reportesService.getReporte5().subscribe(data => {
      this.reportes = data;
    });
  
  
  }


}
