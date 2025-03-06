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
public class Marcar extends Comando {
    private String simboloJuego;
    private int posX;
    private int posY;
    
    public Marcar(String simboloJuego, int posX, int posY){
        super();
        super.setCodigoComando("0008");
        this.simboloJuego = simboloJuego;
        this.posX = posX;
        this.posY = posY;
    }
    
    public Marcar(){}
    
    @Override
    public void parsear(String message) throws Exception {
        String[] partes = message.split("\\|");
        String comando = partes[0].trim();

        if(partes.length != 4) {
            throw new Exception("Formato incorrecto, escriba el comando, el simbolo X u O y las posiciones, divididos de '|'");
        } if(comando.length() != 4 || !comando.equals("0008")) {
            throw new Exception("Comando incorrecto");
        }
        
        String s = partes[1].trim();
       
        if(!s.equalsIgnoreCase("X") && !s.equalsIgnoreCase("O")) {
            throw new Exception("Símbolo incorrecto. Use 'X' o 'O'");
        }       
        
        int posX = Integer.parseInt(partes[2].trim());
        int posY = Integer.parseInt(partes[3].trim());
        
        try {                   
            if (posX < 0 || posX > 2 || posY < 0 || posY > 2) {
                throw new Exception("Posiciones inválidas");
            }            
        } catch (NumberFormatException e) {
            throw new Exception("Las posiciones deben ser números enteros.");
        }
        
        super.setCodigoComando(comando);
        this.simboloJuego = s;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String getComando() {
        String mensaje = super.getCodigoComando() + "|" + this.simboloJuego + "|" + this.posX + "|" + this.posY;
        return mensaje;
    }
    
}
