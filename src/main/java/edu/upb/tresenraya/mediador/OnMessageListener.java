package edu.upb.tresenraya.mediador;

import edu.upb.tresenraya.comandos.Comando;

public interface OnMessageListener {
    void onMessage(String message);
    void onMessage(Comando c);
    void onMessageCliente(String message);
    void onClose();     
    void onChangeColour(String colour);
}
