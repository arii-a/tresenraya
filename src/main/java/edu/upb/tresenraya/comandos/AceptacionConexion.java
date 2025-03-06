/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.comandos;

import lombok.Getter;

/**
 *
 * @author Ariana
 */
@Getter
public class AceptacionConexion extends Comando {
    private String nombre;
    

    public AceptacionConexion(String nombre) {
        super();
        super.setCodigoComando("0003");
        this.nombre = nombre;
    }
    
    public AceptacionConexion(){}
    
    @Override
    public void parsear(String message) throws Exception {
        String[] partes = message.split("\\|");
        String comando = message.split("\\|")[0];

        if(partes.length != 2) {
            throw new Exception("Comando incorrecto");
        } if(comando.length() != 4 || !comando.equals("0003")) {
            throw new Exception("Comando incorrecto");
        }

        String[] nombre = partes[1].split("\\s+");
        String n = nombre[0];
        
        System.out.println(comando);           
        super.setCodigoComando(comando);
        this.nombre = n;
    }

    @Override
    public String getComando() {
        String mensaje = super.getCodigoComando() + "|" + this.nombre;
        return mensaje;
    }
    
}
