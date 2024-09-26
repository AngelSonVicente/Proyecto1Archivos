/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.ReportesController;
import Model.JsonUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author MSI
 */
public class ReportesService {

    JsonUtil jsonUtil = new JsonUtil();
    ReportesController reportes = new ReportesController();

    public void procesarSolicitud(int reporte, String fecha1, String fecha2, HttpServletResponse response) throws IOException {

        switch (reporte) {
            case 1:

                break;

            case 2:

                jsonUtil.EnviarListaJson(response, reportes.gettop10VentasGrandes(fecha1, fecha2));

                break;
            case 3:
                jsonUtil.EnviarListaJson(response, reportes.getTOp2SucursalesMasIngresis());

                break;
            case 4:
                jsonUtil.EnviarListaJson(response, reportes.getTop10ProductosMasVendidos());

                break;

            case 5:
                jsonUtil.EnviarListaJson(response, reportes.getTop10ClientesMasGastones());

                break;

            default:
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

}
