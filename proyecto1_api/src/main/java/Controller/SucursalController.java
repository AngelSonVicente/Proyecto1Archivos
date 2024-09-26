/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.SucursalBD;
import Model.ProductoSinPrecio;
import Model.Productos;
import Model.ProductosBodega;
import Model.Sucursal;
import java.sql.SQLException;
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
   
   public ProductosBodega agregarProductos (ProductosBodega productos) throws SQLException{
   
   return sucursalBD.ingresarProductos(productos);
   }
   
   public List<Productos> getProductosSinPrecio(int codigo){
   
   return sucursalBD.getProductosSinPrecio(codigo);
   }
   
   public ProductoSinPrecio actualizarPrecioPasillo(ProductoSinPrecio producto) throws SQLException{
   
       return sucursalBD.actualizarPrecioPasillo(producto);
   }
   
    
    
    
    
    
}
