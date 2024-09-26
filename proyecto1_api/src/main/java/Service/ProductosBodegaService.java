package Service;

import Controller.ProductosBodegasController;
import Model.JsonUtil;
import Model.ProductosBodega;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author MSI
 */
public class ProductosBodegaService {

    JsonUtil jsonUtil = new JsonUtil();
    ProductosBodegasController productosController = new ProductosBodegasController();

    public void ingresarProductos(String body, HttpServletResponse response) throws IOException, SQLException {

        ProductosBodega productosBodega = (ProductosBodega) jsonUtil.JsonStringAObjeto(body, ProductosBodega.class);

        jsonUtil.EnviarJson(response, productosController.ingresarProductos(productosBodega));

    }

}
