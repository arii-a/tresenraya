package Clase;
/* 
 *
 * @author Ariana
 */
public class CiempiesDomestico extends Bicho{

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

    public CiempiesDomestico(int cantOjos, int añosVida, int cantPatas, String habitad, String dieta, String metodoDeDefensa, String nombre, boolean vuela, boolean camina, boolean seCamufla, boolean tieneAntena, boolean tieneCola) {
        super(cantOjos, añosVida, cantPatas, habitad, dieta, metodoDeDefensa, nombre, vuela, camina, seCamufla, tieneAntena, tieneCola);
    }

    public CiempiesDomestico(){
        
    }

    public String getPata1Derecha() {
        return pata1Derecha;
    }

    public void setPata1Derecha(String pata1Derecha) {
        this.pata1Derecha = pata1Derecha;
    }

    public String getPata1Izquierda() {
        return pata1Izquierda;
    }

    public void setPata1Izquierda(String pata1Izquierda) {
        this.pata1Izquierda = pata1Izquierda;
    }

    public String getPata2Derecha() {
        return pata2Derecha;
    }

    public void setPata2Derecha(String pata2Derecha) {
        this.pata2Derecha = pata2Derecha;
    }

    public String getPata2Izquierda() {
        return pata2Izquierda;
    }

    public void setPata2Izquierda(String pata2Izquierda) {
        this.pata2Izquierda = pata2Izquierda;
    }

    public String getPata3Derecha() {
        return pata3Derecha;
    }

    public void setPata3Derecha(String pata3Derecha) {
        this.pata3Derecha = pata3Derecha;
    }

    public String getPata3Izquierda() {
        return pata3Izquierda;
    }

    public void setPata3Izquierda(String pata3Izquierda) {
        this.pata3Izquierda = pata3Izquierda;
    }

    public String getPata4Derecha() {
        return pata4Derecha;
    }

    public void setPata4Derecha(String pata4Derecha) {
        this.pata4Derecha = pata4Derecha;
    }

    public String getPata4Izquierda() {
        return pata4Izquierda;
    }

    public void setPata4Izquierda(String pata4Izquierda) {
        this.pata4Izquierda = pata4Izquierda;
    }

    public String getPata5Derecha() {
        return pata5Derecha;
    }

    public void setPata5Derecha(String pata5Derecha) {
        this.pata5Derecha = pata5Derecha;
    }

    public String getPata5Izquierda() {
        return pata5Izquierda;
    }

    public void setPata5Izquierda(String pata5Izquierda) {
        this.pata5Izquierda = pata5Izquierda;
    }

    public String getPata6Derecha() {
        return pata6Derecha;
    }

    public void setPata6Derecha(String pata6Derecha) {
        this.pata6Derecha = pata6Derecha;
    }

    public String getPata6Izquierda() {
        return pata6Izquierda;
    }

    public void setPata6Izquierda(String pata6Izquierda) {
        this.pata6Izquierda = pata6Izquierda;
    }

    public String getPata7Derecha() {
        return pata7Derecha;
    }

    public void setPata7Derecha(String pata7Derecha) {
        this.pata7Derecha = pata7Derecha;
    }

    public String getPata7Izquierda() {
        return pata7Izquierda;
    }

    public void setPata7Izquierda(String pata7Izquierda) {
        this.pata7Izquierda = pata7Izquierda;
    }

    public String getPata8Derecha() {
        return pata8Derecha;
    }

    public void setPata8Derecha(String pata8Derecha) {
        this.pata8Derecha = pata8Derecha;
    }

    public String getPata8Izquierda() {
        return pata8Izquierda;
    }

    public void setPata8Izquierda(String pata8Izquierda) {
        this.pata8Izquierda = pata8Izquierda;
    }

    public String getPata9Derecha() {
        return pata9Derecha;
    }

    public void setPata9Derecha(String pata9Derecha) {
        this.pata9Derecha = pata9Derecha;
    }

    public String getPata9Izquierda() {
        return pata9Izquierda;
    }

    public void setPata9Izquierda(String pata9Izquierda) {
        this.pata9Izquierda = pata9Izquierda;
    }

    public String getPata10Derecha() {
        return pata10Derecha;
    }

    public void setPata10Derecha(String pata10Derecha) {
        this.pata10Derecha = pata10Derecha;
    }

    public String getPata10Izquierda() {
        return pata10Izquierda;
    }

    public void setPata10Izquierda(String pata10Izquierda) {
        this.pata10Izquierda = pata10Izquierda;
    }

    public String getPata11Derecha() {
        return pata11Derecha;
    }

    public void setPata11Derecha(String pata11Derecha) {
        this.pata11Derecha = pata11Derecha;
    }

    public String getPata11Izquierda() {
        return pata11Izquierda;
    }

    public void setPata11Izquierda(String pata11Izquierda) {
        this.pata11Izquierda = pata11Izquierda;
    }

    public String getPata12Derecha() {
        return pata12Derecha;
    }

    public void setPata12Derecha(String pata12Derecha) {
        this.pata12Derecha = pata12Derecha;
    }

    public String getPata12Izquierda() {
        return pata12Izquierda;
    }

    public void setPata12Izquierda(String pata12Izquierda) {
        this.pata12Izquierda = pata12Izquierda;
    }

    public String getPata13Derecha() {
        return pata13Derecha;
    }

    public void setPata13Derecha(String pata13Derecha) {
        this.pata13Derecha = pata13Derecha;
    }

    public String getPata13Izquierda() {
        return pata13Izquierda;
    }

    public void setPata13Izquierda(String pata13Izquierda) {
        this.pata13Izquierda = pata13Izquierda;
    }

    public String getPata14Derecha() {
        return pata14Derecha;
    }

    public void setPata14Derecha(String pata14Derecha) {
        this.pata14Derecha = pata14Derecha;
    }

    public String getPata14Izquierda() {
        return pata14Izquierda;
    }

    public void setPata14Izquierda(String pata14Izquierda) {
        this.pata14Izquierda = pata14Izquierda;
    }

    public String getPata15Derecha() {
        return pata15Derecha;
    }

    public void setPata15Derecha(String pata15Derecha) {
        this.pata15Derecha = pata15Derecha;
    }

    public String getPata15Izquierda() {
        return pata15Izquierda;
    }

    public void setPata15Izquierda(String pata15Izquierda) {
        this.pata15Izquierda = pata15Izquierda;
    }

    public boolean isEsVenenoso() {
        return esVenenoso;
    }

    public void setEsVenenoso(boolean esVenenoso) {
        this.esVenenoso = esVenenoso;
    }

    public boolean isNocturno() {
        return nocturno;
    }

    public void setNocturno(boolean nocturno) {
        this.nocturno = nocturno;
    }

    public boolean isPuedeRegenerar() {
        return puedeRegenerar;
    }

    public void setPuedeRegenerar(boolean puedeRegenerar) {
        this.puedeRegenerar = puedeRegenerar;
    }

    public boolean isSensibleAVibraciones() {
        return sensibleAVibraciones;
    }

    public void setSensibleAVibraciones(boolean sensibleAVibraciones) {
        this.sensibleAVibraciones = sensibleAVibraciones;
    }

    public boolean isMudaPiel() {
        return mudaPiel;
    }

    public void setMudaPiel(boolean mudaPiel) {
        this.mudaPiel = mudaPiel;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public static CiempiesDomesticoBuilder builder() {
        return new CiempiesDomesticoBuilder();
    }
    

    
}
