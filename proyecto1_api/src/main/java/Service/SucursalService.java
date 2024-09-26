/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.SucursalController;
import Model.JsonUtil;
import Model.ProductoSinPrecio;
import Model.Productos;
import Model.ProductosBodega;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class SucursalService {

    private SucursalController sucursarController = new SucursalController();

    private JsonUtil jsonUtil = new JsonUtil();

    public void procesarSOlicitudGET(int codigo, HttpServletResponse response) throws InvalidDataException, InvalidDataException, IOException {

        validar(codigo);

        List<Productos> lista = sucursarController.getProductosSucursal(codigo);
        System.out.println(lista);

        jsonUtil.EnviarListaJson(response, lista);

    }

    public void agregarProductosSucursal(String body, HttpServletResponse response) throws IOException, SQLException {

        ProductosBodega productos = (ProductosBodega) jsonUtil.JsonStringAObjeto(body, ProductosBodega.class);

        jsonUtil.EnviarJson(response, sucursarController.agregarProductos(productos));

    }

    public void getSucursales(HttpServletResponse response) throws IOException {

        jsonUtil.EnviarListaJson(response, sucursarController.getSucursales());

    }

    public void InventarioGET(int codigoSucursal, HttpServletResponse response) throws IOException {

        if (codigoSucursal > 0) {

            jsonUtil.EnviarListaJson(response, sucursarController.getProductosSinPrecio(codigoSucursal));

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

    public void ActualizarPrecioPasillo(String body, HttpServletResponse response) throws IOException, InvalidDataException, SQLException {

        ProductoSinPrecio producto = (ProductoSinPrecio) jsonUtil.JsonStringAObjeto(body, ProductoSinPrecio.class);

        validar(producto);

        jsonUtil.EnviarJson(response, sucursarController.actualizarPrecioPasillo(producto));

    }

    private void validar(int codigo) throws InvalidDataException {

        if (codigo <= 0) {

            throw new InvalidDataException("El codigo es invalido");

        }

    }

    private void validar(ProductoSinPrecio producto) throws InvalidDataException {
        if (producto.getCodigoProducto() < 0
                || producto.getCodigoSucursal() < 0
                || producto.getPasillo() == null
                || producto.getPrecio() < 0) {
            throw new InvalidDataException("Los datos estan incorrectos o invalidos");

        }

    }
}
