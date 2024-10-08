/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.SucursalService;
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
@WebServlet(name = "ProductosSucursalController", urlPatterns = {"/v1/ProductosSucursal"})

public class ProductosSucursalServlet extends HttpServlet {

    SucursalService sucursalService = new SucursalService();
    JsonUtil jsonUtil = new JsonUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("SERVLET PRODUCTOS ");
        int codigo = Integer.parseInt(request.getParameter("codigoSucursal"));
        try {
            sucursalService.procesarSOlicitudGET(codigo, response);

        } catch (InvalidDataException ex) {

            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String body = jsonUtil.getBody(request);

        System.out.println(body);

        try {
            sucursalService.agregarProductosSucursal(body, response);
        } catch (SQLException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            
            System.out.println(ex);

        }

    }

}
