/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Ariana
 */
@Builder
@ToString
@Data
public class Universidad {
    private String nombre;
    private int cantidadAulas; 
   
}
