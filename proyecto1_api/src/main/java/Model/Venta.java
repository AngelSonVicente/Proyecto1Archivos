/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author MSI
 */
public class Venta {
    
    private int codigo;
    private int nitCliente;
    private int codigoCajero;
    private String fecha;
    private float total;
    private int puntosUsados;
    private List<Productos> productos;

    public Venta() {
    }

    public Venta(int codigo, int nitCliente, int codigoCajero, String fecha, float total, int puntosUsados, List<Productos> productos) {
        this.codigo = codigo;
        this.nitCliente = nitCliente;
        this.codigoCajero = codigoCajero;
        this.fecha = fecha;
        this.total = total;
        this.puntosUsados = puntosUsados;
        this.productos = productos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(int nitCliente) {
        this.nitCliente = nitCliente;
    }

    public int getCodigoCajero() {
        return codigoCajero;
    }

    public void setCodigoCajero(int codigoCajero) {
        this.codigoCajero = codigoCajero;
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

    public int getPuntosUsados() {
        return puntosUsados;
    }

    public void setPuntosUsados(int puntosUsados) {
        this.puntosUsados = puntosUsados;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo=" + codigo + ", nitCliente=" + nitCliente + ", codigoCajero=" + codigoCajero + ", fecha=" + fecha + ", total=" + total + ", puntosUsados=" + puntosUsados + ", productos=" + productos + '}';
    }
    
     
    
    
    
}
