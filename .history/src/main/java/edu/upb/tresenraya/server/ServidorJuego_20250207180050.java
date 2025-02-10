/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import edu.upb.tresenraya.Mediador;
import edu.upb.tresenraya.OnMessageListener;
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
                
            }

        }

    }

    @Override
    public void onMessage(String message) {
       System.out.println(message);
    }

}
