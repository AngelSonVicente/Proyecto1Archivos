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
public class ProductosBodega {
    
    private int codigoBodega;
    private List<Productos> productos;

    public ProductosBodega() {
    }

    public ProductosBodega(int codigoBodega, List<Productos> productos) {
        this.codigoBodega = codigoBodega;
        this.productos = productos;
    }

    public int getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(int codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "ProductosBodega{" + "codigoBodega=" + codigoBodega + ", productos=" + productos + '}';
    }
    
    

    
}
