/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Ariana
 */
public abstract class Bicho {
    int cantOjos,
    añosVida,
    cantPatas;
    String habitad,
    dieta,
    metodoDeDefensa,  
    nombre;
    boolean vuela,
    camina,
    seCamufla,
    tieneAntena,
    tieneCola;

    public Bicho(int cantOjos, int añosVida, int cantPatas, String habitad, String dieta, String metodoDeDefensa, String nombre, boolean vuela, boolean camina, boolean seCamufla, boolean tieneAntena, boolean tieneCola) {
        this.cantOjos = cantOjos;
        this.añosVida = añosVida;
        this.cantPatas = cantPatas;
        this.habitad = habitad;
        this.dieta = dieta;
        this.metodoDeDefensa = metodoDeDefensa;
        this.nombre = nombre;
        this.vuela = vuela;
        this.camina = camina;
        this.seCamufla = seCamufla;
        this.tieneAntena = tieneAntena;
        this.tieneCola = tieneCola;
    }

    public Bicho(){
        
    }
    
}
