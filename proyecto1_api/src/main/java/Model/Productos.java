/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author MSI
 */
public class Productos {
    
    private int codigoProducto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String sub_categoria;
    private String plataforma;
    private float precio;
    private int existencias;
    private String pasillo;

    public Productos() {
    }

    public Productos(int codigoProdcuto, String nombre, String descripcion, String categoria, String sub_categoria, String plataforma, float precio, int existencias, String pasillo) {
        this.codigoProducto = codigoProdcuto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.sub_categoria = sub_categoria;
        this.plataforma = plataforma;
        this.precio = precio;
        this.existencias = existencias;
        this.pasillo = pasillo;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProdcuto) {
        this.codigoProducto = codigoProdcuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSub_categoria() {
        return sub_categoria;
    }

    public void setSub_categoria(String sub_categoria) {
        this.sub_categoria = sub_categoria;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    @Override
    public String toString() {
        return "\nProductos{" + "codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", sub_categoria=" + sub_categoria + ", plataforma=" + plataforma + ", precio=" + precio + ", existencias=" + existencias + ", pasillo=" + pasillo + '}';
    }
    
    
    
            
    
  
    
    
    
    
    
    
}
