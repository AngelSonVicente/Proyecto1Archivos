/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author MSI
 */
public class ClientesGastado {
    
    private int nit;
    private String nombre;
    private String direccion;
    private String correo;
    private float gastado;

    public ClientesGastado(int nit, String nombre, String direccion, String correo, float gastado) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.gastado = gastado;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public float getGastado() {
        return gastado;
    }

    public void setGastado(float gastado) {
        this.gastado = gastado;
    }
    
    

    
    
}
