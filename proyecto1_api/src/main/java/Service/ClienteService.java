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

    public void validar(int codigo) throws InvalidDataException {
        if (codigo <= 0) {

            throw new InvalidDataException("El codigo es invalido");

        }

    }

}
