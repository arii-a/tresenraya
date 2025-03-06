/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import mediador.Mediador;
import mediador.OnMessageListener;
import edu.upb.tresenraya.TresEnRayaUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rlaredo
 */
public class ServidorJuego extends Thread implements OnMessageListener {

    private final ServerSocket serverSocket;
    private final TresEnRayaUI tresEnRaya;

    public ServidorJuego(TresEnRayaUI tresEnRaya) throws IOException {
        this.serverSocket = new ServerSocket(1825);
        this.tresEnRaya = tresEnRaya;
        Mediador.addListener(this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                SocketClient client = new SocketClient(socket);
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    @Override
    public void onMessage(String message) {
       System.out.println(message);
    }

    @Override
    public void onClose() {
        System.out.println("Servidor: Se ha cerrado la conexión");
    }

    @Override
    public void onMessageCliente(String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onChangeColour(String colour) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onChangeColour'");
    }

}
