/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.ProductosBD;
import Model.Productos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ProductosController {

    private ProductosBD productosBD = new ProductosBD();

    public List<Productos> getProductos() throws SQLException {

        return productosBD.getProductos();
    }

    public Productos getProducto(int codigo) {

        return null;
    }

    public Productos crearProducto(Productos producto) throws SQLException {

        return productosBD.crearProducto(producto);

    }

}
