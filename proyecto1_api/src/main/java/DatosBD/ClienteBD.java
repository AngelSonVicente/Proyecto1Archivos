/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.Cliente;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MSI
 */
public class ClienteBD {

    Connection conexion = null;

    public ClienteBD() {
        ConexionPG conexionPg = new ConexionPG();
        conexion = conexionPg.getConexion();

    }
    private static final String SELECT_BY_NIT = "SELECT * FROM ventas.cliente_view WHERE nit=?;";
    private static final String CREAR_USUARIO = "INSERT INTO ventas.clientes (nit,nombre,correo,direccion) values (?,?,?,?);";

    public Cliente getClienteNit(int nit) {
        // validateCarnet not null
        try {
            PreparedStatement select = conexion.prepareStatement(SELECT_BY_NIT);
            select.setInt(1, nit);
            ResultSet resultset = select.executeQuery();
            System.out.println("----------------------------------------------------");
            System.out.println(select.toString());

            if (resultset.next()) {
                return new Cliente(resultset.getInt("nit"),
                        resultset.getString("nombre"), resultset.getString("correo"),
                        resultset.getString("direccion"), resultset.getFloat("total_gastado"),
                        resultset.getInt("puntos"), resultset.getString("tipo"), resultset.getString("fecha_creacion")
                );
            }

            return null;
        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();
        }

        return null;
    }

    public Cliente crearCliente(Cliente cliente) throws SQLException {
        
        System.out.println(cliente.toString());

        PreparedStatement insert = conexion.prepareStatement(CREAR_USUARIO);
        insert.setInt(1, cliente.getNit());
        insert.setString(2, cliente.getNombre());
        insert.setString(3, cliente.getCorreo());
        insert.setString(4, cliente.getDireccion());

        System.out.println("------------Creando Cliente------------");
        System.out.println(insert.toString());
        int affectedRows = insert.executeUpdate();

        if (affectedRows >= 0) {
            return cliente;

        }

        return null;
    }

}
