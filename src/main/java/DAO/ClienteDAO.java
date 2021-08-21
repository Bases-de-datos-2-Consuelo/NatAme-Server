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

    public String agregarCliente(Connection conn,Cliente cliente) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO natame.CLIENTE VALUES("+cliente.getK_CLIENTE()+")";
        System.out.println(sql);

        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close();
            return "Guardado correctamente.";

        } catch (SQLException e) {
            return e.getMessage();
        }
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
