/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.backend;

import java.util.Scanner;

/**
 *
 * @author Ariana
 */
public class TresEnRayaJuego {
    String[][] matrizJuego = new String[3][3];
    
    public void xO(String[][] matriz, String posicion, String xO) {
        int posFil = Integer.parseInt(posicion.split(",")[0]);
        int posCol = Integer.parseInt(posicion.split(",")[1]);
        
        matriz[posFil-1][posCol-1] = xO;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TresEnRayaJuego juego = new TresEnRayaJuego();
        System.out.print("Bienvenido al juego de Tres en Raya\n");
        juego.imprimirTablero();

        while(!juego.verificarEmpate(juego.matrizJuego) && !juego.verificarGanador(juego.matrizJuego)) {
            System.out.println("Ingrese la posición y la letra (x o o) separados por un espacio");    
            String mensaje = scanner.nextLine();
            juego.xO(juego.matrizJuego, mensaje.split(" ")[0], mensaje.split(" ")[1]);
            juego.imprimirTablero();
        }
        
    }
    
}
