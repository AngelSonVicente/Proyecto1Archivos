/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.JsonUtil;
import Model.Venta;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author MSI
 */
public class VentaService {
    
    JsonUtil jsonUtil = new JsonUtil();
    public void ProcesarSolicitud(String body, HttpServletResponse response) throws IOException{
    
        Venta venta = (Venta) jsonUtil.JsonStringAObjeto(body, Venta.class);
        
        System.out.println("VENTA: " + venta.toString());
        
        
        
        
    
    }
    
    
    public void validar(){
    
    
    }
    
    
}
