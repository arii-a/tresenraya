package edu.upb.tresenraya.mediador;

/**
 *
 * @author Ariana
 */
public interface OnJuegoListener {
    void onSendDatos(String datos);
    void onGanador(String ganador);
    void onEmpate();
    void onInvalidMove();
}
