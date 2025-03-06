package mediador;

public interface OnMessageListener {
    void onMessage(String message);
    void onMessageCliente(String message);
    void onClose();     
    void onColourChange(String colour);
}
