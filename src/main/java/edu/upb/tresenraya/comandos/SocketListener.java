/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.upb.tresenraya.comandos;

import edu.upb.tresenraya.server.SocketClient;

/**
 *
 * @author Ariana
 */
public interface SocketListener {
    
     void onNewClient(SocketClient sc);
    
}
