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

public class SolicitudConexion extends Comando {
    private String nombre;
    private String ip;
    
    public SolicitudConexion(String nombre, String ip) {
        super();
        super.setCodigoComando("0001");
        this.nombre = nombre;
    }
    
    public SolicitudConexion(){}

    @Override
    public void parsear(String message) throws Exception {
        String[] partes = message.split("\\|");
        String comando = message.split("\\|")[0];

        if(partes.length != 2) {
            System.out.println("Este es el comando: " + comando);
            throw new Exception("Comando incorrecto");
        } if(comando.length() != 4 || !comando.equals("0001")) {
            System.out.println("Este es el comando: " + comando);
            throw new Exception("Comando incorrecto");
        }

        String[] nombre = partes[1].split("\\s+");
        String n = nombre[0];
                     
        super.setCodigoComando(comando);
        this.nombre = n;
    }

    @Override
    public String getComando() {
        String mensaje = super.getCodigoComando() + "|" + this.nombre;
        return mensaje;
    }
    
    
    
}
