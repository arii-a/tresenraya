package edu.upb.tresenraya.mediador;

public interface OnMessageListener {
    void onMessage(String message);
    void onMessageCliente(String message);
    void onClose();     
    void onChangeColour(String colour);
}
