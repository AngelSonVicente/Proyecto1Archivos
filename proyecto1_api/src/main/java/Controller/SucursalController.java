/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.SucursalBD;
import Model.Productos;
import Model.Sucursal;
import java.util.List;


/**
 *
 * @author MSI
 */
public class SucursalController {
    
   private  SucursalBD sucursalBD = new SucursalBD();
    
   public List<Productos> getProductosSucursal(int codigo){
       return sucursalBD.getProductosSucursal(codigo);
   }
   
   public List<Sucursal> getSucursales(){
       return sucursalBD.getSucursales();
   }
   
    
    
    
    
    
}
