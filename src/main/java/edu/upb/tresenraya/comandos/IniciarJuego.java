package edu.upb.tresenraya.comandos;

import lombok.Getter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ariana
 */
@Getter
public class IniciarJuego extends Comando {
    private String simboloJuego;
    
    public IniciarJuego(String simboloJuego){
        super();
        super.setCodigoComando("0004");
        this.simboloJuego = simboloJuego;
    }
    
    public IniciarJuego(){
        super.setCodigoComando("0004");
    }
    
    @Override
    public void parsear(String message) throws Exception {
        String[] partes = message.split("\\|");
        String comando = message.split("\\|")[0];

        if(partes.length != 2) {
            throw new Exception("Formato incorrecto, escriba el comando y el simbolo X u O, divididos de '|'");
        } if(comando.length() != 4 || !comando.equals("0004")) {
            throw new Exception("Comando incorrecto");
        }
        
        String[] simbolo = partes[1].split("\\s+");
        String s = simbolo[0];
       
        if(simbolo.length > 1 || (!s.equalsIgnoreCase("X") && !s.equalsIgnoreCase("O"))) {
            throw new Exception("Formato incorrecto, escriba el comando y el simbolo X u O, divididos de '|'");
        }       
        
        super.setCodigoComando(comando);
        this.simboloJuego = s;
    }

    @Override
    public String getComando() {
        String mensaje = super.getCodigoComando() + "|" + this.simboloJuego;
        return mensaje;
    }
    
}
