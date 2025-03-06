/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.mediador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Ariana
 */
public class MediadorJuego {
    public static List<OnJuegoListener> lister = new CopyOnWriteArrayList<>();
    
    public MediadorJuego() {
        
    }
    
    
    
    public static void addListenerJuego(OnJuegoListener juegoListener){
        lister.add(juegoListener);
    }

    public static void sendMessageJuego(String msg) {
        for (OnJuegoListener onJuegoListener: lister) {
            onJuegoListener.onSendDatos(msg);
        }
    }
    
    public static void sendGanador(String ganador) {
        for (OnJuegoListener onJuegoListener: lister) {
            onJuegoListener.onGanador(ganador);
        }
    }
    
    public static void sendEmpateo() {
        for (OnJuegoListener onJuegoListener: lister) {
            onJuegoListener.onEmpate();
        }
    }
    
    public static void sendInvalidMove() {
        for (OnJuegoListener onJuegoListener: lister) {
            onJuegoListener.onInvalidMove();
        }
    }

    
}
