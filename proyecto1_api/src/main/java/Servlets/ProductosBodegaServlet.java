/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.ProductosBodegaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
@WebServlet(name = "ProductosBodegaCOntroller", urlPatterns = {"/v1/ProductosBodega"})
public class ProductosBodegaServlet extends HttpServlet {

    JsonUtil jsonUtil = new JsonUtil();

    ProductosBodegaService bodegasService = new ProductosBodegaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int codigo = Integer.parseInt(request.getParameter("codigoBodega"));

        try {
            bodegasService.getProductos(codigo, response);
        } catch (IOException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = jsonUtil.getBody(request);
        System.out.println(body);

        try {
            bodegasService.ingresarProductos(body, response);
        } catch (SQLException ex) {

            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

}
