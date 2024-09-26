/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.ProductosBodegaBD;
import Model.ProductosBodega;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class ProductosBodegasController {
    
    ProductosBodegaBD productosBodegaBD= new ProductosBodegaBD();
    
    
    public ProductosBodega ingresarProductos(ProductosBodega productos) throws SQLException{
        
        return productosBodegaBD.ingresarProductos(productos);
    
    }
    
    
}
