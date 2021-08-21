/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.modelos.Usuario;

/**
 *
 * @author luisy
 */
public class UsuarioDAO {
    
    String mensaje;
    //CREAR
    public String agregarUsuario(Connection conn, Usuario u) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO NATAME.USUARIO\n" +
"(K_USUARIO, N_NOMBRE1, N_NOMBRE2, N_APELLIDO1, N_APELLIDO2, I_TIPO_DOCUMENTO, N_DOCUMENTO, N_DIRECCION, N_CORREO, I_GENERO, F_NACIMIENTO, N_TELEFONO)\n" +
"VALUES('"+u.getK_USUARIO()+"', '"+u.getN_APELLIDO1()+"', '"+u.getN_NOMBRE2()+"', '"+u.getN_APELLIDO1()+"', '"+u.getN_APELLIDO2()+"', '"+u.getI_TIPO_DOCUMENTO()+"', '"+u.getN_DOCUMENTO()+"', '"+u.getN_DIRECCION()+"', '"+u.getN_CORREO()+"', '"+u.getI_GENERO()+"', TIMESTAMP '"+u.getF_NACIMIENTO()+"', '"+u.getN_TELEFONO()+"');";

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
    //MODIFICAR
    //CONSULTAR
    //ELIMINAR
}
