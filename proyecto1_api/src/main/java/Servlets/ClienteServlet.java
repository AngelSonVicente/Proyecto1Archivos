/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.ClienteService;
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
@WebServlet(name = "ClienteController", urlPatterns = {"/v1/Cliente"})

public class ClienteServlet extends HttpServlet {

    private JsonUtil jsonUtil = new JsonUtil();
    ClienteService clienteService = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("nitCliente"));
        try {
            clienteService.procesarSolicitudGET(codigo, response);
        } catch (InvalidDataException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = jsonUtil.getBody(request);
        
        System.out.println(body);

        try {
            clienteService.CrearCliente(body, response);
        } catch (InvalidDataException | SQLException ex) {

            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

}
