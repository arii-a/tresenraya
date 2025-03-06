/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.backend;

/**
 *
 * @author Ariana
 */
public class TresEnRayaJuego {
    String[][] matrizJuego = new String[3][3];
    
    public void xO(String[][] matriz, String posicion, String xO) {
        int posFil = Integer.parseInt(posicion.split(",")[0]);
        int posCol = Integer.parseInt(posicion.split(",")[1]);
        
        matriz[posFil-1][posCol-1] = xO;
    }
    
    
    
}
