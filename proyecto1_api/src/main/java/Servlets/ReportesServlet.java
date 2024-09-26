/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Service.ReportesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
@WebServlet(name = "ReportesServlet", urlPatterns = {"/v1/Reportes"})
public class ReportesServlet extends HttpServlet {
    
    ReportesService reportes = new ReportesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
        try {
            reportes.procesarSolicitud(Integer.parseInt(request.getParameter("reporte")), request.getParameter("fecha1"), request.getParameter("fecha2"), response);
        } catch (ParseException ex) {
            
            
        }
        
        
    
        
    }

    
    
    
    
}
