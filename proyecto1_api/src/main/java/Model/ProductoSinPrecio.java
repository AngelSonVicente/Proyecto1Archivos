/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author MSI
 */
public class ProductoSinPrecio {

    private int codigoProducto;
    private int codigoSucursal;
    private float precio;
    private String pasillo;

    public ProductoSinPrecio() {
    }

    public ProductoSinPrecio(int codigoProducto, int codigoSucursal, float precio, String pasillo) {
        this.codigoProducto = codigoProducto;
        this.codigoSucursal = codigoSucursal;
        this.precio = precio;
        this.pasillo = pasillo;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

}
