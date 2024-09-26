/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
@WebServlet(name = "InventarioCpntroller", urlPatterns = {"/v1/Inventario"})
public class InventarioServlet extends HttpServlet {

    SucursalService sucursalSevice = new SucursalService();
    JsonUtil jsonUtil = new JsonUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int codigoSucursa = Integer.parseInt(request.getParameter("codigoSucursal"));

        sucursalSevice.InventarioGET(codigoSucursa, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = jsonUtil.getBody(request);

        try {
            sucursalSevice.ActualizarPrecioPasillo(body, response);
        } catch (InvalidDataException | SQLException ex) {
            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

}
