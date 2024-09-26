import { Component, OnInit } from '@angular/core';
import { VentasGrandes } from 'src/entities/VentasGrandes';
import { ReportesService } from 'src/services/ReportesService';

@Component({
  selector: 'app-reporte1',
  templateUrl: './reporte1.component.html',
  styleUrls: ['./reporte1.component.css']
})
export class Reporte1Component implements OnInit {

  ventas!:VentasGrandes[];

  constructor(private reportesService:ReportesService){


  }


  ngOnInit(): void {




  }
}
