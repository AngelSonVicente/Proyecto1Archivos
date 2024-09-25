/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Service.SucursalService;
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
@WebServlet(name = "SucursalControllerr", urlPatterns = {"/v1/Sucursal"})
public class SucursalServlet extends HttpServlet {

    SucursalService sucursalesService = new SucursalService();
   
    @Override
    protected void doGet(HttpServletRequest reques, HttpServletResponse response) throws ServletException, IOException {
        sucursalesService.getSucursales(response);
        
    
        
    }
    
    

    
}
