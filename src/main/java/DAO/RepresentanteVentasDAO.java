/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.modelos.Cliente;
import negocio.modelos.Representante_Ventas;
import negocio.modelos.Usuario;

/**
 *
 * @author asus
 */
public class RepresentanteVentasDAO {

    private String mensaje = "";

    public RepresentanteVentasDAO() {

    }

    public String agregarRepresentante(Connection conn, Representante_Ventas representante, Usuario usuario) throws SQLException {

        PreparedStatement pstUser = null;
        PreparedStatement pstRole = null;
        PreparedStatement pstUsuario = null;
        PreparedStatement pstRepresentante = null;
        
        String sqlUser = "CREATE USER " + usuario.getK_USUARIO() + " IDENTIFIED  BY \"" + usuario.getK_USUARIO() + "\" default tablespace natdef temporary tablespace nattmp quota 2m on natdef";
        String sqlRole = "GRANT R_REPRESENTANTEVENTA TO " + usuario.getK_USUARIO();
        String sqlUsuario = "INSERT INTO NATAME.USUARIO VALUES('" + usuario.getK_USUARIO() + "','" + usuario.getN_NOMBRE1() + "','" + usuario.getN_NOMBRE2() + "','" + usuario.getN_APELLIDO1() + "','" + usuario.getN_APELLIDO2() + "','" + usuario.getI_TIPO_DOCUMENTO() + "','" + usuario.getN_DOCUMENTO() + "','" + usuario.getN_DIRECCION() + "','" + usuario.getN_CORREO() + "','" + usuario.getI_GENERO() + "', TO_DATE('" + usuario.getF_NACIMIENTO() + "','YYYY-MM-DD'),'" + usuario.getN_TELEFONO() + "')";
        String sqlRepresentante = "INSERT INTO NATAME.REPRESENTANTE_VENTAS VALUES('" + representante.getK_REPRESENTANTE() + "'," + representante.getK_REGION() + "," + representante.getK_PAIS() + ",'" + representante.getK_REPRESENTANTE_SUPERIOR() + "')";
        //String sqlPrueba="SELECT * FROM USUARIO;";

        System.out.println(sqlUser);
        System.out.println(sqlUsuario);
        System.out.println(sqlRepresentante);

        //System.out.println(sql);
        try {
            pstUser = conn.prepareStatement(sqlUser);
            pstUser.execute();
            pstUser.close();

            pstRole = conn.prepareStatement(sqlRole);
            pstRole.execute();
            pstRole.close();

            pstUsuario = conn.prepareStatement(sqlUsuario);
            pstUsuario.execute();
            pstUsuario.close();

            pstRepresentante = conn.prepareStatement(sqlRepresentante);
            pstRepresentante.execute();
            pstRepresentante.close();
            return "Guardado correctamente.";

        } catch (SQLException e) {

            PreparedStatement pstRollback = null;
            String sqlRollback = "ROLLBACK"; 
            pstRollback = conn.prepareStatement(sqlRollback);
            pstRollback.execute();
            pstRollback.close();

            System.out.println(e);
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
