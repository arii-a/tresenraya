/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;


import edu.upb.tresenraya.comandos.AceptacionConexion;
import edu.upb.tresenraya.comandos.AceptacionJuego;
import edu.upb.tresenraya.comandos.CerrarConexion;
import edu.upb.tresenraya.comandos.Comando;
import edu.upb.tresenraya.comandos.IniciarJuego;
import edu.upb.tresenraya.comandos.Marcar;
import edu.upb.tresenraya.comandos.MovimientoAdicional;
import edu.upb.tresenraya.comandos.NuevaPartida;
import edu.upb.tresenraya.comandos.RechazoConexion;
import edu.upb.tresenraya.comandos.RechazoJuego;
import edu.upb.tresenraya.comandos.SolicitudConexion;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import edu.upb.tresenraya.mediador.Mediador;
import edu.upb.tresenraya.mediador.MediadorCliente;
import edu.upb.tresenraya.mediador.OnMessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rlaredo
 */

@Getter
@Setter
public class SocketClient extends Thread implements OnMessageListener {
    private final Socket socket;
    private final String ip;
    private final DataOutputStream dout;
    private final BufferedReader br;
    

    public SocketClient(Socket socket) throws IOException {
        this.socket = socket;
        this.ip = socket.getInetAddress().getHostAddress();
        dout = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        MediadorCliente.addListenerCliente(this);
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = br.readLine()) != null) {
                System.out.println(message);
                if (message.equals("cerrar")) {
                    Mediador.onClose();
                    break;
                } if (message.equalsIgnoreCase("cerrar todo")) {
                    Mediador.onTotalClose();
                } if (message.split(" ")[0].equalsIgnoreCase("color") || message.split(" ")[0].equalsIgnoreCase("colour")) {
                    Mediador.onChangeColour(message.split(" ")[1]);

                //Comandos -->    
                } if (message.contains("0001")) {
                    Comando c = new SolicitudConexion();
                    try {
                        c.parsear(message);
                        ((SolicitudConexion) c).setIp(this.ip);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (message.contains("0002")) {
                    Comando c = new RechazoConexion();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Mediador.sendMessage(c);
                }
                if (message.contains("0003")) {
                    Comando c = new AceptacionConexion();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (message.contains("0004")) {
                    Comando c = new IniciarJuego();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (message.contains("0005")) {
                    Comando c = new RechazoJuego();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (message.contains("0006")) {
                    Comando c = new AceptacionJuego();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (message.contains("0007")) {
                    Comando c = new NuevaPartida();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (message.contains("0008")) {
                    Comando c = new Marcar();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                if (message.contains("0010")) {
                    System.out.println("Cerrando conexión propia");
                    closeConnection();
                    break; 
                } 
                if (message.contains("0011")) {
                    Comando c = new MovimientoAdicional();
                    try {
                        c.parsear(message);
                        Mediador.sendMessage(c);
                    } catch (Exception ex) {
                        Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Mediador.sendMessage(message + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public synchronized void send(byte[] buffer) {
        try {
            dout.write(buffer);
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public synchronized void sendMessage(String msg) {
        try {
            dout.write((msg + System.lineSeparator()).getBytes());
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) throws IOException {
        SocketClient socketClient = new SocketClient(new Socket("localhost", 1825));
        socketClient.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            System.out.println("Escriba un mensaje: ");
            socketClient.send((br.readLine()+System.lineSeparator()).getBytes());
        }
    }
   
    public void closeConnection() {
        try {
            if (br != null) {
                br.close();
            }
            if (dout != null) {
                dout.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            System.out.println("Conexión cerrada con " + ip);
        } catch (IOException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(String message) {
    }

    @Override
    public void onMessageCliente(String message) {
        try {
            System.out.println("Mensaje recibido");
            dout.write((message + System.lineSeparator()).getBytes());
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   

    @Override
    public void onClose() {
    }

    @Override
    public void onChangeColour(String colour) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onMessage(Comando c) {
    }


}