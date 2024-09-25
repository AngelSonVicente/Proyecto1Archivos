/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.SucursalController;
import Model.JsonUtil;
import Model.Productos;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class SucursalService {

    private SucursalController sucursarController = new SucursalController();

    private JsonUtil jsonUtil = new JsonUtil();
    
    public void procesarSOlicitudGET(int codigo, HttpServletResponse response) throws InvalidDataException, InvalidDataException, IOException {
      
        
        validar(codigo);
        
        
        List<Productos> lista =sucursarController.getProductosSucursal(codigo);
        System.out.println(lista);
        
        jsonUtil.EnviarListaJson(response,lista );
        
        
        
        
        
        

    }
    
    public void getSucursales(HttpServletResponse response) throws IOException{
        
        jsonUtil.EnviarListaJson(response, sucursarController.getSucursales());
    
        
        
    }
    

    private void validar(int codigo) throws InvalidDataException {

        if (codigo <= 0) {

           throw new InvalidDataException("El codigo es invalido");

        }

    }

}
