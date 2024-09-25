/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.BodegaController;
import Model.Bodega;
import Model.JsonUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author MSI
 */
public class BodegaService {

    BodegaController bodegaController = new BodegaController();

    JsonUtil jsonUtil = new JsonUtil();
    
    public void  getBodegas(HttpServletResponse response) throws IOException {
      
        jsonUtil.EnviarListaJson(response,bodegaController.getBodegas());
       
    
    }

}
