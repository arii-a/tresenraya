/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.backend.metodoDePago;

import java.math.BigDecimal;

/**
 *
 * @author Ariana
 */
public abstract class MetodoPago {
    private BigDecimal monto;
    private String nombre;
    
    public MetodoPago (String name) {
        this.nombre = name;
    }
    
    public static MetodoPago create(String name) {
        if(name.equals("QR")){
            return new MetodoPagoQr();
        } if(name.equals("Tarjeta")) {
            return new MetodoPagoTarjeta();
        }
        
        return null;
    }
    
    protected abstract String cobrar(BigDecimal monto);
    
}
