/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.comandos;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ariana
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto  implements Serializable{
    private String name;
    private String ip;
    private boolean stateConnect = false;
    
}