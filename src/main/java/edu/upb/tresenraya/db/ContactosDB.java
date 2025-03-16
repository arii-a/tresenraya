/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ariana
 */
@Getter
@Setter
public class ContactosDB {
    private String ip;
    private String nombre;
    
    public ContactosDB(String ip, String nombre) {
        this.ip = ip;
        this.nombre = nombre;
    }

    public static void addContacto(String ipC, String nombreC) {
        String sql = "INSERT INTO contactos (ip, nombre) VALUES (?, ?)";
        try (Connection conn = ConexionDB.onstance().getConection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ipC);
            pstmt.setString(2, nombreC);
            pstmt.executeUpdate();
            System.out.println("Contacto insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar contacto: " + e.getMessage());
        }
    }
    
    public static List<ContactosDB> getContactos() {
        List<ContactosDB> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        
        try (Connection conn = ConexionDB.onstance().getConection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new ContactosDB(rs.getString("ip"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener contactos: " + e.getMessage());
        }
        
        return lista;
    }
    
    public static boolean deleteContacto(String ipC) {
        String sql = "DELETE FROM contactos WHERE ip = " + ipC;
        
        try (Connection conn = ConexionDB.onstance().getConection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ipC);  // ✅ Evita errores de sintaxis
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar contacto: " + e.getMessage());
            return false;
        }
    }
}
