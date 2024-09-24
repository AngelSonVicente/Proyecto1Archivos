/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.Util;
import Model.Venta;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MSI
 */
public class VentasBD {
    Connection conexion = null;
    private Util util = new Util();

    public VentasBD() {
    ConexionPG conexionPg= new ConexionPG(); 
    this.conexion = conexionPg.getConexion();
    
    
    }
    
      // (nit_cliente, codigo_cajero, puntos_a_usar, listaProductos, ListaUnidades, codigo_sucursal);   
    private static final String INSERT_VENTA="SELECT ventas.procesar_factura(?, ?, ?, ?, ?, ?);";
    
      public Venta realizarventa(Venta venta) throws SQLException {
     
       
          PreparedStatement insert = conexion.prepareStatement(INSERT_VENTA, PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setInt(1, venta.getNitCliente());
            insert.setInt(2, venta.getCodigoCajero());
            insert.setInt(3, venta.getPuntosUsados());
            insert.setArray(4,  conexion.createArrayOf("INTEGER", util.getIdProductos(venta)));
            insert.setArray(5,conexion.createArrayOf("INTEGER", util.getCantidadProductos(venta)));
            insert.setInt(6, venta.getCodigoSucursal());
            
            
            
           
            
            System.out.println("------------Creando VENTA------------");
            System.out.println(insert.toString());
            ResultSet resultset = insert.executeQuery();
            if(resultset.next()){
            
                return venta;
            }
          
            
                
      

        return null;
    }
    
    
    
    
    
    
    
    
}
