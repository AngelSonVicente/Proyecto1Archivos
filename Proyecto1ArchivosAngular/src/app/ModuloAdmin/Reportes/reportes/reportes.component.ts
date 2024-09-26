import { Component, OnInit } from '@angular/core';
import { ReportesService } from 'src/services/ReportesService';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit{
  
  selectedReport = '';
  fecha1!: string;
fecha2!: string;
showReporte3 = false;

  constructor(private reportesService: ReportesService) { }

  ngOnInit(): void {
  
    
  }


}
