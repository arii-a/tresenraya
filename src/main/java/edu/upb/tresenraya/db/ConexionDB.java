/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.db;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ariana
 */
public class ConexionDB {
    private String url = "jdbc:sqlite:C:\\Users\\Ariana\\tres_en_raya_DB";
    private String user = "";
    private String pass = "";
    private int port = 0;
    private static ConexionDB db = new ConexionDB();
    
    private ConexionDB(){
        System.out.println("iniciando singletton");
    }
   
    public static ConexionDB onstance() {
        return db;
    }
    
    public Connection getConection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.url);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e ) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        
        return conn;
    }
    
}
