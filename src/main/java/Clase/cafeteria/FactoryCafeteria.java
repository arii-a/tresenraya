/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase.cafeteria;

/**
 *
 * @author Ariana
 */
public class FactoryCafeteria {
    public Cafeteria create(String bebida) {
        if(bebida.equals("Expreso")) 
            return new Expreso();
        
        if(bebida.equals("Latte")) 
            return new Latte();
        
        return null;
    }
}
