/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.VentasController;
import Model.JsonUtil;
import Model.Venta;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class VentaService {

    private JsonUtil jsonUtil = new JsonUtil();
    private VentasController ventasController = new VentasController();

    public void ProcesarSolicitud(String body, HttpServletResponse response) throws IOException, InvalidDataException, SQLException {

        Venta venta = (Venta) jsonUtil.JsonStringAObjeto(body, Venta.class);
        
        validar(venta);

        ventasController.realizarVenta(venta);
        
        jsonUtil.EnviarJson(response, venta);
        
        
    }

    public void validar(Venta venta) throws InvalidDataException {

        if (venta.getCodigoCajero() <= 0
                || venta.getCodigoSucursal() <= 0
                || venta.getProductos() == null) {

            throw new InvalidDataException("Datos incompletos d ela venta, porfavor de revisar los datos");

        }

    }

}
