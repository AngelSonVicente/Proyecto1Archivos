import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Usuario} from 'src/entities/Usuario';
import { Venta } from "src/entities/Venta";
import { ProductosBodega } from "src/entities/ProductosBodega";
@Injectable({
    providedIn: 'root'
})
export class ProductosBodegaService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public ingresarProductos(ingreso: ProductosBodega): Observable<ProductosBodega> {

        console.log('connectando con el BE: ' + ingreso);
        
        return this.httpClient.post<ProductosBodega>(this.API_URL + "ProductosBodega", ingreso);
    }

 
}