/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class SucursalBD {
    
    Connection conexion= null;

    public SucursalBD() {
        ConexionPG conexionPg = new ConexionPG();
        conexion = conexionPg.getConexion();
    
    
    }
    
    
    private static final String SELECT_PRODCUTOS_SUCURSAL="SELECT * FROM sucursales.productos_sucursal WHERE codigo_sucursal=?";
    
    
    
        public List<Productos> getProductosSucursal(int codigo) {
        List<Productos> productos = new ArrayList<>();
        try {
     
            PreparedStatement select = conexion.prepareStatement(SELECT_PRODCUTOS_SUCURSAL);
            select.setInt(1, codigo);
            System.out.println(select.toString());
            
            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                productos.add(new Productos(
                        resultset.getInt("codigo_producto"), resultset.getString("nombre"),
                        resultset.getString("descripcion"), resultset.getString("categoria"), resultset.getString("sub_categoria"),
                        resultset.getString("plataforma"), resultset.getFloat("precio"), resultset.getInt("existencias"),
                        resultset.getString("pasillo")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
            System.out.println("Productos"+productos);

        return productos;
    }
    
    
    
}
