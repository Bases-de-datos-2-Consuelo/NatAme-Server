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

    public String agregarRepresentante(Connection conn, Representante_Ventas representante) throws SQLException {

        PreparedStatement pstUser = null;
        PreparedStatement pstRole = null;
        PreparedStatement pstUsuario = null;
        PreparedStatement pstRepresentante = null;
        
        String sqlUser = "CREATE USER " + representante.getK_REPRESENTANTE() + " IDENTIFIED  BY \"" + representante.getK_REPRESENTANTE() + "\" default tablespace natdef temporary tablespace nattmp quota 2m on natdef";
        String sqlRole = "GRANT R_REPRESENTANTEVENTA TO " + representante.getK_REPRESENTANTE();
        //String sqlUsuario = "INSERT INTO NATAME.USUARIO VALUES('" + representante.getK_REPRESENTANTE() + "','" + representante.getN_NOMBRE1() + "','" + representante.getN_NOMBRE2() + "','" + representante.getN_APELLIDO1() + "','" + representante.getN_APELLIDO2() + "','" + representante.getI_TIPO_DOCUMENTO() + "','" + representante.getN_DOCUMENTO() + "','" + representante.getN_DIRECCION() + "','" + representante.getN_CORREO() + "','" + representante.getI_GENERO() + "', TO_DATE('" + representante.getF_NACIMIENTO() + "','YYYY-MM-DD'),'" + representante.getN_TELEFONO() + "')";
        String sqlRepresentante = "INSERT INTO NATAME.REPRESENTANTE_VENTAS VALUES('" + representante.getK_REPRESENTANTE() + "','" + representante.getK_REGION() + "','" + representante.getK_PAIS() + "','" + representante.getK_REPRESENTANTE_SUPERIOR() +representante.getN_NOMBRE1() + "','" + representante.getN_NOMBRE2() + "','" + representante.getN_APELLIDO1() + "','" + representante.getN_APELLIDO2() + "','" + representante.getI_TIPO_DOCUMENTO() + "','" + "','" + representante.getN_DOCUMENTO() + "','" + representante.getN_DIRECCION() + "','" + representante.getN_CORREO() + "','" + representante.getI_GENERO()+ "', TO_DATE('" + representante.getF_NACIMIENTO() + "','YYYY-MM-DD'),'" + representante.getN_TELEFONO()  + "')";
        //String sqlPrueba="SELECT * FROM USUARIO;";

        System.out.println(sqlUser);
        //System.out.println(sqlUsuario);
        System.out.println(sqlRepresentante);

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
