/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.modelos.Pais;

/**
 *
 * @author luisy
 */
public class PaisDAO {
    
    Pais pais = new Pais();
    private String mensaje = "";
    
    public PaisDAO(){
        
    }

    public String AgregarPais(Connection conn,String n_pais) {
        PreparedStatement pst = null;
        System.out.println("VALOR PAIS "+ n_pais);
        String sql = "INSERT INTO PAIS VALUES(NULL,'"+n_pais+"')";

        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close();
            System.out.println("Guardado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al guardar " + e.getMessage());
            mensaje = e.getMessage();
        }

        return mensaje;
    }
}
