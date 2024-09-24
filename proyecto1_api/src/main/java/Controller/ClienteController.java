/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.ClienteBD;
import Model.Cliente;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class ClienteController {
   private ClienteBD clienteBD = new ClienteBD();
   
   
   
   
    public Cliente getClienteNit(int nit){
    
    return clienteBD.getClienteNit(nit);
    }
    
    public Cliente crearCliente (Cliente cliente) throws SQLException{
    
        return clienteBD.crearCliente(cliente);
    
    }
    
}
