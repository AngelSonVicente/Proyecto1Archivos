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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ProductosBD {

    Connection conexion = null;

    public ProductosBD() {
        ConexionPG conexionPG = new ConexionPG();

        conexion = conexionPG.getConexion();

    }

    private static final String TODOS_LOS_PRODUCTOS = "SELECT * FROM productos.producto;";
    private static final String CREAR_PRODUCTO="INSERT INTO productos.producto (nombre,descripcion,categoria,sub_categoria,plataforma) VALUES (?,?,?,?,?);";

    
    public List<Productos> getProductos() throws SQLException {
        List<Productos> productos = new ArrayList<>();

        PreparedStatement select = conexion.prepareStatement(TODOS_LOS_PRODUCTOS);

        System.out.println(select.toString());

        ResultSet resultset = select.executeQuery();
        while (resultset.next()) {
            productos.add(new Productos(
                    resultset.getInt("codigo"), resultset.getString("nombre"),
                    resultset.getString("descripcion"), resultset.getString("categoria"), resultset.getString("sub_categoria"),
                    resultset.getString("plataforma"), 0.0f, 0,
                    null
            ));
        }

        System.out.println("Productos" + productos);

        return productos;
    }
    
    
        public Productos crearProducto(Productos producto) {
    
            try {
            PreparedStatement insert = conexion.prepareStatement(CREAR_PRODUCTO, PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setString(1, producto.getNombre());
            insert.setString(2, producto.getDescripcion());
            insert.setString(3, producto.getCategoria());
            insert.setString(4, producto.getSub_categoria());
            insert.setString(5, producto.getPlataforma());
       
            
           
            System.out.println(insert.toString());
            int affectedRows = insert.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La inserción no tuvo éxito, ningún ID generado.");
            }

            try (ResultSet generatedKeys = insert.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    System.out.println("Oferta Creada");
                    producto.setCodigoProducto(generatedID);
                    return producto;
                } else {
                    throw new SQLException("La inserción no tuvo éxito, ningún ID generado.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
