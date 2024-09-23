import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Observable, catchError, map, of } from "rxjs";
import { Productos } from "src/entities/Productos";

@Injectable({
    providedIn: 'root'
})
export class ProductosSucursalesService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

 
    
    
  
    public getProductosSucursal(codigoUsuario: number): Observable<Productos[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<Productos[]>(this.API_URL + "ProductosSucursal?codigoSucursal="+codigoUsuario);
    }

    
 
}