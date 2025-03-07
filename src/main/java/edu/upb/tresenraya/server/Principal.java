/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import edu.upb.tresenraya.comandos.AceptacionJuego;
import edu.upb.tresenraya.comandos.Comando;
import edu.upb.tresenraya.comandos.IniciarJuego;
import edu.upb.tresenraya.comandos.Marcar;

/**
 *
 * @author Ariana
 */
public class Principal {
    private static MyCollection<String> listita = new MyCollection<>();   
    private static MyCollection<Comando> liste = new MyCollection<>();
    
    public static void main(String[] args) {
        Marcar marcar = new Marcar();
        IniciarJuego iniciarJuego = new IniciarJuego();
        AceptacionJuego aceptacionJuego = new AceptacionJuego();
        
        listita.addAllItem("uno", "dos", "tres", "cuatro", "once", "treinta y cuatro", "sesenta y nueve", "cero", "noventa y nueve", "trece");  
        while (listita.hasNext()) {
            String next = listita.getNext();
            //System.out.print(next + " ");
        }
        
        liste.addAllItem(marcar, iniciarJuego, aceptacionJuego);
        while (liste.hasNext()) {
            Comando next = liste.getNext();
            System.out.print(next.getCodigoComando() + " - ");
        }
        liste.setIndex(2);
        System.out.println("");
        System.out.println(liste.getLista().get(liste.getIndex()).getCodigoComando());
        System.out.println(liste.getPrevious().getCodigoComando());
        
    }
    
    
}
