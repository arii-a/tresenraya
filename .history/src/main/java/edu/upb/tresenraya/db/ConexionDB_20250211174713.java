/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.db;

import java.sql.Connection;

/**
 *
 * @author Ariana
 */
public class ConexionDB {
    private String url;
    private String user;
    private String pass;
    private int port;
    private static ConexionDB db = new ConexionDB();
    
    private ConexionDB(){
        System.out.println("iniciando singletton");
    }
   
    public static ConexionDB onstance() {
        return db;
    }
    
    public Connection getConection() {
        //logica
        
        return null;
    }
    
}
