/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.mediador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariana
 */
public class MediadorCliente {
    public static List<OnMessageListener> lister = new ArrayList<>();
    
    public MediadorCliente(){
        
    }
    
    public static void addListenerCliente(OnMessageListener messageListener){
        lister.add(messageListener);
    }

    public static void sendMessageCliente(String msg) {
        for (OnMessageListener onMessageListener: lister) {
            onMessageListener.onMessageCliente(msg);
        }
    }
    
}
