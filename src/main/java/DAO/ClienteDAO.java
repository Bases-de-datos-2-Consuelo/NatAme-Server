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

//    public String agregarCliente(Connection conn,Cliente cliente) {
//        PreparedStatement pst = null;
//        String sql = "INSERT INTO natame.CLIENTE VALUES("+cliente.getK_CLIENTE()+")";
//        System.out.println(sql);
//
//        try {
//            pst = conn.prepareStatement(sql);
//            pst.execute();
//            pst.close();
//            return "Guardado correctamente.";
//
//        } catch (SQLException e) {
//            return e.getMessage();
//        }
//    }
public String agregarCliente(Connection conn, Cliente cliente) throws SQLException {

        PreparedStatement pstUser = null;
        PreparedStatement pstRole = null;
        PreparedStatement pstUsuario = null;
        PreparedStatement pstRepresentante = null;
        
        String sqlUser = "CREATE USER " + cliente.getK_CLIENTE() + " IDENTIFIED  BY \"" + cliente.getK_CLIENTE() + "\" default tablespace natdef temporary tablespace nattmp quota 2m on natdef";
        String sqlRole = "GRANT R_CLIENTE TO " + cliente.getK_CLIENTE();
        //String sqlUsuario = "INSERT INTO NATAME.USUARIO VALUES('" + representante.getK_REPRESENTANTE() + "','" + representante.getN_NOMBRE1() + "','" + representante.getN_NOMBRE2() + "','" + representante.getN_APELLIDO1() + "','" + representante.getN_APELLIDO2() + "','" + representante.getI_TIPO_DOCUMENTO() + "','" + representante.getN_DOCUMENTO() + "','" + representante.getN_DIRECCION() + "','" + representante.getN_CORREO() + "','" + representante.getI_GENERO() + "', TO_DATE('" + representante.getF_NACIMIENTO() + "','YYYY-MM-DD'),'" + representante.getN_TELEFONO() + "')";
        String sqlCliente = "INSERT INTO NATAME.REPRESENTANTE_VENTAS VALUES('" + cliente.getK_CLIENTE() + "','" +cliente.getN_NOMBRE1() + "','" + cliente.getN_NOMBRE2() + "','" + cliente.getN_APELLIDO1() + "','" + cliente.getN_APELLIDO2() + "','" + cliente.getI_TIPO_DOCUMENTO() + "','" + "','" + cliente.getN_DOCUMENTO() + "','" + cliente.getN_DIRECCION() + "','" + cliente.getN_CORREO() + "','" + cliente.getI_GENERO()+ "', TO_DATE('" + cliente.getF_NACIMIENTO() + "','YYYY-MM-DD'),'"  + "')";
        //String sqlPrueba="SELECT * FROM USUARIO;";

        System.out.println(sqlUser);
        //System.out.println(sqlUsuario);
        System.out.println(sqlCliente);

        //System.out.println(sql);
        try {
            pstUser = conn.prepareStatement(sqlUser);
            pstUser.execute();
            pstUser.close();

            pstRole = conn.prepareStatement(sqlRole);
            pstRole.execute();
            pstRole.close();

//            pstUsuario = conn.prepareStatement(sqlUsuario);
//            pstUsuario.execute();
//            pstUsuario.close();

            pstRepresentante = conn.prepareStatement(sqlCliente);
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
