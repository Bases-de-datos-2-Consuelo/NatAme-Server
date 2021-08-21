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
import negocio.modelos.RepresentanteVentas;

/**
 *
 * @author asus
 */
public class RepresentanteVentasDAO {

    private String mensaje = "";

    public RepresentanteVentasDAO() {
    }

    public String agregarCliente(Connection conn,RepresentanteVentas representante) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO natame.CLIENTE VALUES("+representante.getK_REPRESENTANTE()+",'"+representante.getN_NOMBRE1()+"','"+representante.getN_NOMBRE2()+"','"+representante.getN_APELLIDO1()+"','"+representante.getN_APELLIDO2()+"', '"+representante.getI_TIPO_DOCUMENTO()+"', '"+representante.getQ_DOCUMENTO()+"','"+representante.getN_DIRECCION()+"','"+representante.getN_CIUDAD()+"','"+representante.getN_CORREO()+"',"+representante.getQ_TELEFONO()+")";
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
