/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio12;

import java.time.LocalDate;

/**
 *
 * Rubén Frechoso Toca DAW1
 */
public class Main {
    public static void main(String[] args) {
      // crear un pedido
        int numPedido = 1;
        LocalDate fechaPedido = LocalDate.of(2023, 5, 19);
        String numCliente = "AD35";
        String cliente = "Grupo Armando Alvarez";
        String direccion = "Avda. Pablo Garnica, 20 39300 Torrelavega - Cantabria";
        Tasas tasa = Tasas.EU;
        String tipo = "ORO";
        
        Pedido miPedido = new Pedido(numPedido, fechaPedido, numCliente, cliente, direccion, tasa, tipo);
        // crear lineas de pedido
        LineaPedido linea1 = new LineaPedido("Pigmento azul 10K", 215.25d, 200);
        LineaPedido linea2 = new LineaPedido("Pigmento verde 10K", 125.85d, 50);
        LineaPedido linea3 = new LineaPedido("Pigmento negro 10K", 60.99d, 600);
        
        if (miPedido.insertarLinea(linea1)) {
            System.out.println("insertado correctamente");
        } else {
            System.out.println("error en la inserción");
        }
        if (miPedido.insertarLinea(linea2)) {
            System.out.println("insertado correctamente");
        } else {
            System.out.println("error en la inserción");
        }
        if (miPedido.insertarLinea(linea3)) {
            System.out.println("insertado correctamente");
        } else {
            System.out.println("error en la inserción");
        }
        
        // mostrar el pedido sin descuento
        miPedido.imprimePedido();
        //el pedido va a tener un descuento en función del tipo 
        miPedido.setDescuento(true);
        if (miPedido.isDescuento()) {
            System.out.println("el cliente es un cliente Oro y en este pedido se aplica el descuento");
            miPedido.imprimePedido();
        } else {;
        }

    }   
}
