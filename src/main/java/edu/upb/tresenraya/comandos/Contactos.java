/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.comandos;

import edu.upb.tresenraya.server.SocketClient;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ariana
 */
@Getter
@Setter
public class Contactos implements SocketListener {
    
    private final Map<String, SocketClient> contatos = new HashMap<>();
    private static Contactos instance = new Contactos();
    private DefaultListModel<String> modeloLista;
    
    private Contactos() {
        MediadorContactos.geInstance().addListener(this);
    }
    
    public static Contactos getInstance(){
        return instance;
    }
    
    @Override
    public void onNewClient(SocketClient sc) {
        synchronized (contatos) {
            contatos.put(sc.getIp(), sc);
        }     
    }
    
    public  void send(String ip, String msg){
        SocketClient sc = this.contatos.get(ip);
        if(sc != null){
            sc.send(msg.getBytes());
        }
    }
    
}
