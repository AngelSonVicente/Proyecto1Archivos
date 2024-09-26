/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.ReportesBD;
import Model.ClientesGastado;
import Model.ProductosVendidos;
import Model.SucursalesIngresos;
import Model.VentasGrandes;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ReportesController {

    ReportesBD reportes = new ReportesBD();

    public List<VentasGrandes> gettop10VentasGrandes(String fecha1, String fecha2) throws ParseException {

        return reportes.getTOp10VentasGrandes(fecha1, fecha2);
    }

    public List<SucursalesIngresos> getTOp2SucursalesMasIngresis() {

        return reportes.getTOp2SucursalesMasIngresis();
    }

    public List<ProductosVendidos> getTop10ProductosMasVendidos() {
        return reportes.getTop10ProductosMasVendidos();
    }

    public List<ClientesGastado> getTop10ClientesMasGastones() {

        return reportes.getTop10ClientesMasGastones();
    }

}
