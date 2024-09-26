/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author MSI
 */
public class VentasGrandes {
    private int codigo;
    private int nit;
    private String nombreCliente;
    private String direccionCliente;
    private String correoCiente;
    private String fecha;
    private float total;

    public VentasGrandes() {
    }

    public VentasGrandes(int codigo, int nit, String nombreCliente, String direccionCliente, String correoCiente, String fecha, float total) {
        this.codigo = codigo;
        this.nit = nit;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.correoCiente = correoCiente;
        this.fecha = fecha;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCorreoCiente() {
        return correoCiente;
    }

    public void setCorreoCiente(String correoCiente) {
        this.correoCiente = correoCiente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
    
    
}
