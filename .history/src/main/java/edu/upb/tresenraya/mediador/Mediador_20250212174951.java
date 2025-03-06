package edu.upb.tresenraya.mediador;

import java.util.ArrayList;
import java.util.List;

public class Mediador {
    public static List<OnMessageListener> lister = new ArrayList<>();

    public Mediador(){

    }

    public static void addListener(OnMessageListener messageListener){
        lister.add(messageListener);
    }

    public static void sendMessage(String msg) {
        for (OnMessageListener onMessageListener: lister) {
            onMessageListener.onMessage(msg);
        }
    }

    public static void onClose() {
        for (OnMessageListener onMessageListener: lister) {
            onMessageListener.onClose();
        }
    }

    public static void onTotalClose(){
        System.exit(0);
    }

    public static void onChangeColour(String colour){
        for (OnMessageListener onMessageListener: lister) {
            onMessageListener.onChangeColour(colour);
        }
    }
    
}
