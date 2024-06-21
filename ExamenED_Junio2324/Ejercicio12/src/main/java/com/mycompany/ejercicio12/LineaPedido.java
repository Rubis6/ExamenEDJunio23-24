/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio12;

/**
 *
 * Rubén Frechoso Toca DAW1
 */
public class LineaPedido {

    protected String articulo;
    protected double precio;
    protected int cantidad;

    public LineaPedido(String articulo, double precio, int cantidad) {
        this.articulo = articulo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Artículo: " + articulo + ", precio: " + precio + ", cantidad: " + cantidad;
    }
}
  
        
        
        


