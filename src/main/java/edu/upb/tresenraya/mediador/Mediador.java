package edu.upb.tresenraya.mediador;

import edu.upb.tresenraya.comandos.Comando;
import edu.upb.tresenraya.server.MyCollection;
import java.util.ArrayList;
import java.util.List;

public class Mediador {
    public static List<OnMessageListener> lister = new ArrayList<>();
    public static MyCollection<OnMessageListener> lister2 = new MyCollection<>();
    
    public Mediador(){

    }

    public static void addListener(OnMessageListener messageListener){
        lister.add(messageListener);
        
        lister2.addItem(messageListener);
    }

    public static void sendMessage(String msg){
        /*while (lister2.hasNext()) {
            OnMessageListener onMessageLister = lister2.getNext();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    onMessageLister.onMessage(msg);
                }
            });
        }*/
        
        for (OnMessageListener onMessageLister : lister) {
           
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    onMessageLister.onMessage(msg);
                }
            });
            
        }
    }
    
        public static void sendMessage(Comando msg){
        for (OnMessageListener onMessageLister : lister) {
           
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                onMessageLister.onMessage(msg);
            }
        });
            
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
