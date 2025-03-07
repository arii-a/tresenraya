/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ariana
 * @param <T>
 */
@Getter
@Setter
public class MyCollection<T> implements Iterator {
    private int index;
    private ArrayList<T> lista = new ArrayList<>();
    
    public MyCollection(int index, ArrayList<T> lista){
        this.index = index;
        this.lista = lista;
    }
    
    public MyCollection(){
        
    }
    
    public void addItem(T element){
        lista.add(element);
    }
    
    public void addAllItem(T... element) {
        for (T elemento : element) {
            lista.add(elemento);
        }
    }
    
    @Override
    public boolean hasNext() {
        return index < lista.size();
    }
    
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public T getNext() {
        if(hasNext()) {
            T elemento = lista.get(index);
            index++;
            return elemento;
        } 
        
        return null;
    }
    
    public T getPrevious(){ 
        if (hasPrevious()) {
            index--;
            T elemento = lista.get(index);
            return elemento;
        }
        return null;
    }
}
