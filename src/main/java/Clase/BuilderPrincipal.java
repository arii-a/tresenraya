/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Ariana
 */
public class BuilderPrincipal {
        public static void main(String[] args) {
            
            CiempiesDomestico c = CiempiesDomestico.builder()
                    .pata10Derecha("pata")
                    .pata11Derecha("pata")
                    .build();
            
            
        //Universidad u = Universidad.builder().nombre("UPB").build();
        //System.out.println(u);
    }
}
