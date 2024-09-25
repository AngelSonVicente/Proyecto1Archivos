/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.ProductosService;
import exceptions.InvalidDataException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
@WebServlet(name = "ProductosController", urlPatterns = {"/v1/Productos"})

public class ProductosServlet extends HttpServlet {

    ProductosService productosService = new ProductosService();
    private JsonUtil jsonUtil = new JsonUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoProducto = 0;
        if (request.getParameter("codigo") != null) {

            codigoProducto = Integer.parseInt(request.getParameter("codigo"));
        }
        System.out.println("productoooo" + codigoProducto);

        try {
            productosService.getProductos(codigoProducto, response);
        } catch (InvalidDataException | SQLException ex) {
            Logger.getLogger(ProductosServlet.class.getName()).log(Level.SEVERE, null, ex);

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = jsonUtil.getBody(request);

        System.out.println(body);
        try {
            productosService.crearProducto(body, response);
        } catch (InvalidDataException | SQLException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

}
