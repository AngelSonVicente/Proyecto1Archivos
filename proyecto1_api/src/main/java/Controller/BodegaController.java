/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.BodegaBD;
import Model.Bodega;
import java.util.List;

/**
 *
 * @author MSI
 */
public class BodegaController {
    BodegaBD bodegaBD = new BodegaBD();
    
    public List<Bodega> getBodegas(){
    
    return bodegaBD.getBodegas();
    }
    
    
}
