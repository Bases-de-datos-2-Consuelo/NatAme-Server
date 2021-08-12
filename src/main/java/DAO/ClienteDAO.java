/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.modelos.Cliente;

/**
 *
 * @author asus
 */
public class ClienteDAO {

    private String mensaje = "";

    public ClienteDAO() {
    }

    public String agregarCliente(Connection conn) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO CLIENTE VALUES(311,'Luis','Miguel','Pérez','Valderrama', 'CC', '123456','carrera 9 #20-50','Bogota','miguel@gmail.com','3103506598')";

        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close();
            System.out.println("Guardado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al guardar " + e.getMessage());
        }

        return mensaje;
    }

    public String modificarCliente(Connection conn, Cliente cliente) {
        return mensaje;
    }

    public String eliminarCliente(Connection conn, String K_CLIENTE) {
        return mensaje;
    }

    public void listarCliente() {
    }

}
