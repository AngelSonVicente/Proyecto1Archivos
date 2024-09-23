/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.VentaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author MSI
 */

@WebServlet(name = "VentaController", urlPatterns = {"/v1/Venta"})

public class VentaServlet extends HttpServlet {
    private JsonUtil jsonUtil = new JsonUtil();
    private VentaService ventaService = new VentaService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
          String body = jsonUtil.getBody(request);
          
          ventaService.ProcesarSolicitud(body, response);
        
          
          
        
        
        
        
        
    }
    
    
    
    
}
