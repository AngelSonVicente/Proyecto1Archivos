/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.Bodega;
import Model.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class BodegaBD {

    Connection conexion = null;

    public BodegaBD() {

        ConexionPG conexionPG = new ConexionPG();
        conexion = conexionPG.getConexion();

    }

    private static final String SELECT_BODEGAS = "SELECT * FROM sucursales.bodegas";

    public List<Bodega> getBodegas() {
        List<Bodega> bodegas = new ArrayList<>();
        try {

            PreparedStatement select = conexion.prepareStatement(SELECT_BODEGAS);

            System.out.println(select.toString());

            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                bodegas.add(new Bodega(
                        resultset.getInt("codigo"), resultset.getString("nombre"),
                        resultset.getString("Direccion")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        System.out.println("Bodegas" + bodegas);

        return bodegas;
    }

}
