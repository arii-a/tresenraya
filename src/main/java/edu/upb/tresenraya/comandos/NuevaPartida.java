/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.comandos;

/**
 *
 * @author Ariana
 */
public class NuevaPartida extends Comando {
    
    public NuevaPartida() {
        super();
        super.setCodigoComando("0007");
    }
    
    @Override
    public void parsear(String message) throws Exception {
        if(!message.equals("0007")){
            throw new Exception("Formato incorrecto, escriba el comando");
        }
        
        super.setCodigoComando(message);
    }

    @Override
    public String getComando() {
        return super.getCodigoComando();
    }
    
}
