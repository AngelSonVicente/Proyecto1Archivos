/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.ClientesGastado;
import Model.Productos;
import Model.ProductosVendidos;
import Model.SucursalesIngresos;
import Model.VentasGrandes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ReportesBD {

    Connection conexion = null;

    public ReportesBD() {
        ConexionPG conexionPG = new ConexionPG();
        conexion = conexionPG.getConexion();
    }

    public static final String TOP10_VENTAS_MAS_GRANDES = "SELECT * FROM empleados.top10_ventas_mas_grandes WHERE fecha BETWEEN ? AND ?;";
    public static final String TOP2_SUCURSALES_CON_INGRESOS = "SELECT *FROM empleados.top2_sucursales_que_mas_generan;";
    public static final String TOP10_PRODUCTOS_MAS_VENDIDOS = "SELECT * FROM empleados.top10_productos_mas_vendidos;";
    public static final String TOP10_CLIENTES_MAS_GASTONES = "SELECT * FROM empleados.top10_clientes_mas_gastones;";

    public List<VentasGrandes> getTOp10VentasGrandes(String fecha1, String fecha2) throws ParseException {
        List<VentasGrandes> ventas = new ArrayList<>();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        // Convertir String a java.util.Date
        java.util.Date fechaUtil = formato.parse(fecha1);

        // Convertir java.util.Date a java.sql.Date
        java.sql.Date fechaSQL1 = new java.sql.Date(fechaUtil.getTime());
        java.util.Date fechaUtil2 = formato.parse(fecha2);

        // Convertir java.util.Date a java.sql.Date
        java.sql.Date fechaSQL2 = new java.sql.Date(fechaUtil2.getTime());

        try {

            PreparedStatement select = conexion.prepareStatement(TOP10_VENTAS_MAS_GRANDES);

            select.setDate(1, fechaSQL1);
            select.setDate(2, fechaSQL2);
            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                ventas.add(new VentasGrandes(
                        resultset.getInt("codigo"), resultset.getInt("nit_cliente"),
                        resultset.getString("nombre_cliente"), resultset.getString("direccion"), resultset.getString("correo"),
                        resultset.getString("fecha"), resultset.getFloat("total")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("Productos" + ventas);

        return ventas;
    }

    public List<SucursalesIngresos> getTOp2SucursalesMasIngresis() {
        List<SucursalesIngresos> sucursales = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(TOP2_SUCURSALES_CON_INGRESOS);

            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                sucursales.add(new SucursalesIngresos(
                        resultset.getInt("codigo"), resultset.getString("nombre_sucursal"),
                        resultset.getString("direccion"), resultset.getFloat("total_generado")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("sucursales" + sucursales);

        return sucursales;
    }

    public List<ProductosVendidos> getTop10ProductosMasVendidos() {
        List<ProductosVendidos> productos = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(TOP10_PRODUCTOS_MAS_VENDIDOS);

            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                productos.add(new ProductosVendidos(
                        resultset.getInt("codigo"), resultset.getString("nombre"),
                        resultset.getString("descripcion"), resultset.getString("categoria"),
                        resultset.getString("sub_categoria"), resultset.getString("plataforma"),
                        resultset.getInt("total_unidades_vendidas")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("productos" + productos);

        return productos;
    }

    public List<ClientesGastado> getTop10ClientesMasGastones() {
        List<ClientesGastado> clientes = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(TOP10_CLIENTES_MAS_GASTONES);

            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                clientes.add(new ClientesGastado(
                        resultset.getInt("nit"), resultset.getString("nombre_cliente"),
                        resultset.getString("direccion"), resultset.getString("correo"),
                        resultset.getFloat("total_gastado")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("productos" + clientes);

        return clientes;
    }

}
