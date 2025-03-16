package edu.upb.tresenraya.mediador;

/**
 *
 * @author Ariana
 */
public interface OnJuegoListener {
    void onInicioJuego();
    void onSendDatos(String datos);
    void onGanador(String ganador);
    void onEmpate();
    void onInvalidMove();
}
