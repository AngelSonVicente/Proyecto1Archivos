package DatosBD;

import Model.Productos;
import Model.ProductosBodega;
import Model.Util;
import Model.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private static final String PRODUCTOS_BODEGA = "SELECT * FROM  sucursales.productos_bodega WHERE codigo_bodega=?;";

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

        public List<Productos> getProductosBodega(int codigo) {
        List<Productos> productos = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(PRODUCTOS_BODEGA);
            select.setInt(1, codigo);
            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                productos.add(new Productos(
                        resultset.getInt("codigo_producto"), resultset.getString("nombre"),
                        resultset.getString("descripcion"), resultset.getString("categoria"), resultset.getString("sub_categoria"),
                        resultset.getString("plataforma"), 0.0f, resultset.getInt("existencias"),
                        null
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("Productos" + productos);

        return productos;
    }
    
}
