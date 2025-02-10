package edu.upb.tresenraya;

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
    
}
