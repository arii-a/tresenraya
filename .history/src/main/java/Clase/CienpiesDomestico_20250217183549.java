package Clase;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ariana
 */
public class CienpiesDomestico extends Bicho{
    @Getter
    @Setter

   String pata1Derecha, pata1Izquierda,
       pata2Derecha, pata2Izquierda,
       pata3Derecha, pata3Izquierda,
       pata4Derecha, pata4Izquierda,
       pata5Derecha, pata5Izquierda,
       pata6Derecha, pata6Izquierda,
       pata7Derecha, pata7Izquierda,
       pata8Derecha, pata8Izquierda,
       pata9Derecha, pata9Izquierda,
       pata10Derecha, pata10Izquierda,
       pata11Derecha, pata11Izquierda,
       pata12Derecha, pata12Izquierda,
       pata13Derecha, pata13Izquierda,
       pata14Derecha, pata14Izquierda,
       pata15Derecha, pata15Izquierda;
   
   boolean esVenenoso,
   nocturno,
   puedeRegenerar,
   sensibleAVibraciones,
   mudaPiel;
   double longitud; 
   String color; 
   int velocidad; 

    public CienpiesDomestico(int cantOjos, int añosVida, int cantPatas, String habitad, String dieta, String metodoDeDefensa, String nombre, boolean vuela, boolean camina, boolean seCamufla, boolean tieneAntena, boolean tieneCola) {
        super(cantOjos, añosVida, cantPatas, habitad, dieta, metodoDeDefensa, nombre, vuela, camina, seCamufla, tieneAntena, tieneCola);
    }

    public CienpiesDomestico(){
        
    }
    
    
}
