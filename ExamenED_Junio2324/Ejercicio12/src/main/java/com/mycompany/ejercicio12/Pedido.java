/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Rubén Frechoso Toca DAW1
 */
public class Pedido {
    
    private int numeroPedido;
    private LocalDate fechaPedido;
    private List<LineaPedido> lineasPedido;
    private boolean descuento;
    private String numeroCliente;
    private String cliente;
    private String direccion;
    private Tasas tasa;
    private String tipo;

    public Pedido(int numeroPedido, LocalDate fechaPedido, String numeroCliente, String cliente, String direccion, Tasas tasa, String tipo) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.descuento = false;
        this.lineasPedido = new ArrayList<>();
        this.numeroCliente = numeroCliente;
        this.cliente = cliente;
        this.direccion = direccion;
        this.tasa = tasa;
        this.tipo = tipo;
    }

    public boolean insertarLinea(LineaPedido lineaPedido) {
        return lineasPedido.add(lineaPedido);
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public double cTotalPedido() {
        if (descuento) {
            return cTotalLineasPedido() - descuento();
        } else {
            return cTotalLineasPedido();
        }
    }

    public double cTotalLineasPedido() {
        double total = 0;
        double precioBase = 0;
        for (LineaPedido lineap : lineasPedido) {
            precioBase = lineap.cantidad * lineap.precio;
            total += precioBase;
        }
        if (tasa.equals(Tasas.EU)) {
            total += total * 0.08d;  //Impuesto sobre la venta de EUA
        } else if (tasa.equals(Tasas.US)) {
            total += total * 0.21d;// IVA europeo
        }
        return total;
    }

    public double descuento() {   //es el tipo de descuento aplicar     
        if (descuento) {
            if (tipo.equals("ORO")) {
                return cTotalLineasPedido() * 0.15d;
            } else if (tipo.equals("PLATA")) {
                return cTotalLineasPedido() * 0.125d;
            } else if (tipo.equals("BRONCE")) {
                return cTotalLineasPedido() * 0.10d;
            } else {
                return cTotalLineasPedido() * 0.0d;
            }
        }
        return cTotalLineasPedido() * 0.0d;
    }

    public void imprimePedido() {
        // impreme cabecera pedido-cliente
        imprimeCabecera();
        // imprime detalle pedido
        System.out.println("Número Pedido: " + numeroPedido);
        for (LineaPedido lineap : lineasPedido) {
            System.out.println("\tArtículo " + lineap.toString());

        }
        System.out.println(String.format("Total Pedido: %,.2f", cTotalPedido()));
    }

    public void imprimeCabecera() {
        System.out.println("Cliente: " + cliente);
        System.out.println("\tNúmero Cliente: " + numeroCliente);
        System.out.println("\tDirección: " + direccion);
        if (tasa.equals(Tasas.EU)) {
            System.out.println("\tTasa: 0,08%");  //Impuesto sobre la venta de EUA
        } else if (tasa.equals(Tasas.US)) {
            System.out.println("\tTasa: 0,21%");  //Iva europeo
        }

    }
    
}
