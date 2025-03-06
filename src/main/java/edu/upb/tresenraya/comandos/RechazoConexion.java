/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.comandos;

/**
 *
 * @author Ariana
 */
public class RechazoConexion extends Comando {

    public RechazoConexion() {
        super();
        super.setCodigoComando("0002");
    }
    
    @Override
    public void parsear(String message) throws Exception {
        if(!message.equals("0002")){
            throw new Exception("Formato incorrecto, escriba el comando");
        }
        
        super.setCodigoComando(message);
    }

    @Override
    public String getComando() {
        return super.getCodigoComando();
    }

}
