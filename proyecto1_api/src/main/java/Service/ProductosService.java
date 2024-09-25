/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.ProductosController;
import Model.JsonUtil;
import Model.Productos;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.http.HttpResponse;

/**
 *
 * @author MSI
 */
public class ProductosService {

    private JsonUtil jsonUtil = new JsonUtil();
    private ProductosController productosController = new ProductosController();

    public void getProductos(int codigo, HttpServletResponse response) throws InvalidDataException, IOException, SQLException {

        validar(codigo);

        if (codigo == 0) {
            //mandar todos los productos 

            jsonUtil.EnviarListaJson(response, productosController.getProductos());

        } else {
            //mandar un solo producto

            jsonUtil.EnviarJson(response, productosController.getProducto(codigo));
        }

    }

    public void crearProducto(String body, HttpServletResponse response) throws SQLException, IOException, InvalidDataException {

        Productos producto = (Productos) jsonUtil.JsonStringAObjeto(body, Productos.class);

        System.out.println("Producto: " + producto.toString());
        validar(producto);
        producto = productosController.crearProducto(producto);
        if (producto == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        } else {
            jsonUtil.EnviarJson(response, productosController.crearProducto(producto));
        }

    }

    private void validar(int codigo) throws InvalidDataException {

        if (codigo < 0) {

            throw new InvalidDataException("El Codigo es invalido ");

        }

    }

    private void validar(Productos producto) throws InvalidDataException {
        if (producto.getNombre() == null
                || producto.getDescripcion() == null
                || producto.getCategoria() == null
                || producto.getSub_categoria() == null
                || producto.getPlataforma() == null) {

            throw new InvalidDataException("Faltan Datos, por favor revise los datos");

        }

    }

}
