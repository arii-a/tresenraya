/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.backend.metodoDePago;
import edu.upb.tresenraya.backend.metodoDePago.MetodoPago;

import java.math.BigDecimal;

/**
 *
 * @author Ariana
 */
public class Principal {
    
    public static void main(String[] args) {
        MetodoPago metodoPago = MetodoPago.create("QR");
        metodoPago.cobrar(new BigDecimal(10));
        
        MetodoPago tarjeta = MetodoPago.create("Tarjeta");
        tarjeta.cobrar(new BigDecimal(10));
    }
   
    
    
}
