/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.VentasBD;
import Model.Venta;

/**
 *
 * @author MSI
 */
public class VentasController {
    private VentasBD ventaBD = new VentasBD();
    
    
    public Venta realizarVenta(Venta venta){
    
      return  ventaBD.realizarventa(venta);
    }
    
    
    
    
    
}
