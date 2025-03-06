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
public class MetodoPagoQr extends MetodoPago{
    public MetodoPagoQr() {
        super("QR");
    }

    @Override
    protected String cobrar(BigDecimal monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
