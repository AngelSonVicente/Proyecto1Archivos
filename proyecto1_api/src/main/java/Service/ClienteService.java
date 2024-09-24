/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.ClienteController;
import Model.Cliente;
import Model.JsonUtil;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class ClienteService {

    ClienteController clienteController = new ClienteController();
    JsonUtil jsonUtil = new JsonUtil();

    public void procesarSolicitudGET(int codigo, HttpServletResponse response) throws InvalidDataException, IOException {

        validar(codigo);

        Cliente cliente = clienteController.getClienteNit(codigo);
        if (cliente != null) {
            jsonUtil.EnviarJson(response, cliente);

        } else {

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

    public void CrearCliente(String body, HttpServletResponse response) throws IOException, SQLException, InvalidDataException {

        Cliente cliente = (Cliente) jsonUtil.JsonStringAObjeto(body, Cliente.class);

        System.out.println(cliente.toString());
        
        validar(cliente);

        cliente = clienteController.crearCliente(cliente);

        jsonUtil.EnviarJson(response, cliente);

    }

    public void validar(int codigo) throws InvalidDataException {
        if (codigo <= 0) {

            throw new InvalidDataException("El codigo es invalido");

        }

    }

    public void validar(Cliente cliente) throws InvalidDataException {
        if (cliente.getNit() <= 0 || cliente.getNombre() == null) {

            throw new InvalidDataException("El nit invalido o no se ha ingresado un nombre");

        }

    }

}
