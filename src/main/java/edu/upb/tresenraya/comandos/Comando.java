/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.comandos;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ariana
 */

@Getter
@Setter
public abstract class Comando {
    String codigoComando;
    
    public abstract void parsear(String message) throws Exception;
    
    public abstract String getComando();
   
}
