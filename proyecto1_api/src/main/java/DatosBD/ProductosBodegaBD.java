package DatosBD;

import Model.ProductosBodega;
import Model.Util;
import Model.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author MSI
 */
public class ProductosBodegaBD {

    Connection conexion = null;

    public ProductosBodegaBD() {
        ConexionPG conexionPG = new ConexionPG();
        conexion = conexionPG.getConexion();

    }
    Util util = new Util();

    private static final String INGRESAR_PRODUCTOS = "SELECT sucursales.ingresar_productos_bodega(?, ?, ?);";

    public ProductosBodega ingresarProductos(ProductosBodega productos) throws SQLException {

        PreparedStatement insert = conexion.prepareStatement(INGRESAR_PRODUCTOS, PreparedStatement.RETURN_GENERATED_KEYS);
        insert.setInt(1, productos.getCodigoBodega());

        insert.setArray(2, conexion.createArrayOf("INTEGER", util.getIdProductos(productos)));
        insert.setArray(3, conexion.createArrayOf("INTEGER", util.getCantidadProductos(productos)));

        System.out.println("------------Creando VENTA------------");
        System.out.println(insert.toString());
        ResultSet resultset = insert.executeQuery();
        if (resultset.next()) {

            return productos;
        }

        return null;
    }

}
