/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase.cafeteria;

/**
 *
 * @author Ariana
 */
public class PrincipalCafeteria {
    
    public static void main(String[] args) {
        FactoryCafeteria cafeteria = new FactoryCafeteria();
        
        System.out.println(cafeteria.create("Expreso").haciendoBebida());
        System.out.println(cafeteria.create("Latte").haciendoBebida());
        
    }
}
