/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Ariana
 */
public class CienpiesDomesticoBuilder {
    private CienpiesDomestico cienpiesDomestico;

    public CienpiesDomesticoBuilder() {
        cienpiesDomestico = new CienpiesDomestico();
    }
    
    public CienpiesDomesticoBuilder pata1Derecha(String pata1Derecha) {
        this.cienpiesDomestico.setPata1Derecha(pata1Derecha);
        return this;
    }
}

