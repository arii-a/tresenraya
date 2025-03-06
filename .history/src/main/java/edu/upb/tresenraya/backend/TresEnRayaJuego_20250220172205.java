/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.backend;

import edu.upb.tresenraya.mediador.MediadorJuego;
import edu.upb.tresenraya.mediador.OnJuegoListener;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ariana
 */
    @Getter
    @Setter


public class TresEnRayaJuego implements OnJuegoListener {
    private String[][] matrizJuego = new String[3][3];
    private String ultimaJugada = "";
    
    public TresEnRayaJuego() {
        MediadorJuego.addListenerJuego(this);
    }

    
    
    public void xO(String[][] matriz, String posicion, String xO) {
        int posFil = Integer.parseInt(posicion.split("")[0]);
        int posCol = Integer.parseInt(posicion.split("")[1]);
        
        if(xO.equals(ultimaJugada)) {
            System.out.println("El jugador "+xO+" ya ha jugado");
        } else {
            matriz[posFil][posCol] = xO;
        }
    }

    public boolean verificarGanador(String[][] matriz) {
        for (int i = 0; i < 3; i++) {
            //verificar filas
            if (matriz[i][0] != null && !matriz[i][0].isEmpty() &&
                matriz[i][0].equals(matriz[i][1]) && matriz[i][0].equals(matriz[i][2])) {
                    System.out.println("Ha ganado el jugador " + matriz[i][0] + " c:");    
                    return true;
            }
            //verificar columnas
            if (matriz[0][i] != null && !matriz[0][i].isEmpty() &&
                matriz[0][i].equals(matriz[1][i]) && matriz[0][i].equals(matriz[2][i])) {
                    System.out.println("Ha ganado el jugador " + matriz[i][0] + " c:");  
                    return true;
            }
        }

        //verificar diagonales
        if (matriz[0][0] != null && !matriz[0][0].isEmpty() &&
            matriz[0][0].equals(matriz[1][1]) && matriz[0][0].equals(matriz[2][2])) {
                System.out.println("Ha ganado el jugador " + matriz[0][0] + " c:");  
                return true;
        }
        if (matriz[0][2] != null && !matriz[0][2].isEmpty() &&
            matriz[0][2].equals(matriz[1][1]) && matriz[0][2].equals(matriz[2][0])) {
                System.out.println("Ha ganado el jugador " + matriz[0][2] + " c:");
                return true;
        }

        return false;
    }

    public boolean verificarEmpate(String[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == null || matriz[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        System.out.println("Ha habido un empate :o");
        return true;
    }

    public void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((matrizJuego[i][j] != null ? matrizJuego[i][j] : "-") + "  ");
            }
            System.out.println(); 
        }
    }
    
    public void iniciarJuego(){
        Scanner scanner = new Scanner(System.in);
        TresEnRayaJuego juego = new TresEnRayaJuego();
        System.out.print("Bienvenido al juego de Tres en Raya\n");
        juego.ultimaJugada = "";
        juego.imprimirTablero();

        while(!juego.verificarEmpate(juego.matrizJuego) && !juego.verificarGanador(juego.matrizJuego)) {
            System.out.println("Ingrese la posición (x,y) y la letra (X o O) separados por un espacio");    
            String mensaje = scanner.nextLine();
            juego.xO(juego.matrizJuego, mensaje.split(" ")[0], mensaje.split(" ")[1]);
            juego.ultimaJugada = mensaje.split(" ")[1];
            juego.imprimirTablero();
        }
    }
    
    public void jugarDesdeInterfaz(String[][] matriz, String posicion, String xO) {
        
        if(!verificarEmpate(this.matrizJuego) && !verificarGanador(this.matrizJuego)) {
            xO(matrizJuego, posicion, xO);
            ultimaJugada = xO;
            imprimirTablero();
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        new TresEnRayaJuego().iniciarJuego();
    }

    @Override
    public void onSendDatos(String datos) {
        System.out.println("Los datos enviados son: " + datos);
        jugarDesdeInterfaz(matrizJuego, datos.split(" ")[0], datos.split(" ")[1]); 
    }
    
}
