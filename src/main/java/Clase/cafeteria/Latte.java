/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase.cafeteria;

/**
 *
 * @author Ariana
 */
public class Latte extends Expreso implements Cafeteria {

    Expreso expreso = new Expreso();
    
    public String procesoBebida() {
        return expreso.haciendoBebida() + " con leche";
    }
    
    @Override
    public String haciendoBebida() {
        return procesoBebida();
    }
    
}
