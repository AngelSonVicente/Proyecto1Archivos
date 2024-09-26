import { Component, OnInit } from '@angular/core';
import { VentasGrandes } from 'src/entities/VentasGrandes';
import { ReportesService } from 'src/services/ReportesService';

@Component({
  selector: 'app-reporte2',
  templateUrl: './reporte2.component.html',
  styleUrls: ['./reporte2.component.css']
})
export class Reporte2Component implements OnInit {

  ventas!: VentasGrandes[];

  fecha1!: string;
  fecha2!: string;

  constructor(private reportesService: ReportesService) { }
  ngOnInit(): void {




  }



  mostrar() {
    if (this.fecha1 != null && this.fecha2 != null) {




      this.reportesService.getReporte2(this.fecha1, this.fecha2).subscribe(data => {
        this.ventas = data;
      });

    }
  }
}


