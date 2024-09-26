/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.ProductoSinPrecio;
import Model.Productos;
import Model.ProductosBodega;
import Model.Sucursal;
import Model.Util;
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

    Connection conexion = null;

    public SucursalBD() {
        ConexionPG conexionPg = new ConexionPG();
        conexion = conexionPg.getConexion();
    }
    Util util = new Util();

    private static final String SELECT_PRODCUTOS_SUCURSAL = "SELECT * FROM sucursales.productos_sucursal WHERE codigo_sucursal=?";
    private static final String SELECT_SUCURSALES = "SELECT * FROM sucursales.sucursal ";
    private static final String INGRESAR_SUCURSAL = "SELECT sucursales.ingresar_productos_sucursal(?, ?, ?);";
    private static final String GET_PRODUCTOS_SIN_PRECIO = "SELECT * FROM sucursales.productos_sucursal WHERE codigo_sucursal=? AND precio is null AND pasillo is null ;";
    private static final String ACTUALIZAR_PRECIO_PASILLO = "UPDATE sucursales.catalogo_sucursal SET precio =?, pasillo=? WHERE codigo_sucursal=? AND codigo_producto=?;";

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
        System.out.println("Productos" + productos);

        return productos;
    }

    public List<Productos> getProductosSinPrecio(int codigo) {
        List<Productos> productos = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(GET_PRODUCTOS_SIN_PRECIO);
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
        System.out.println("Productos" + productos);

        return productos;
    }

    public List<Sucursal> getSucursales() {
        List<Sucursal> sucursales = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(SELECT_SUCURSALES);

            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                sucursales.add(new Sucursal(
                        resultset.getInt("codigo"), resultset.getString("nombre"),
                        resultset.getString("Direccion")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("Sucursales" + sucursales);

        return sucursales;
    }

    public ProductosBodega ingresarProductos(ProductosBodega productos) throws SQLException {

        PreparedStatement insert = conexion.prepareStatement(INGRESAR_SUCURSAL, PreparedStatement.RETURN_GENERATED_KEYS);
        insert.setInt(1, productos.getCodigoBodega());

        insert.setArray(2, conexion.createArrayOf("INTEGER", util.getIdProductos(productos)));
        insert.setArray(3, conexion.createArrayOf("INTEGER", util.getCantidadProductos(productos)));

        System.out.println("------------------------");
        System.out.println(insert.toString());
        ResultSet resultset = insert.executeQuery();
        if (resultset.next()) {

            return productos;
        }

        return null;
    }

    public ProductoSinPrecio actualizarPrecioPasillo(ProductoSinPrecio producto) throws SQLException {
        System.out.println("Actualizando la oferta");

        PreparedStatement update = conexion.prepareStatement(ACTUALIZAR_PRECIO_PASILLO);

        update.setFloat(1, producto.getPrecio());
        update.setString(2, producto.getPasillo());
        update.setInt(3, producto.getCodigoSucursal());
        update.setInt(4, producto.getCodigoProducto());

        int affectedRows = update.executeUpdate();

        if (affectedRows == 1) {
            System.out.println("Oferta actualizada");
            return producto;
        }
        System.out.println("La actualización no tuvo éxito.");

        return null;
    }

}
