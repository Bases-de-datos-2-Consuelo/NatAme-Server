/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public static ArrayList<Cliente> getClientes(String k_usuario) {
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String query = " select c.k_cliente, c.n_nombre1, c.n_apellido1 from cliente c, representante_ventas re, referido rf WHERE re.k_representante = rf.k_representante AND rf.k_cliente = c.k_cliente AND re.k_representante = '"+k_usuario+"' AND rf.f_final IS null";
            
            
            PreparedStatement stPet =  Conexion.getConnection().prepareStatement(query);
            ResultSet result = stPet.executeQuery();
            while(result.next()){
                String k_cliente = result.getString(1);
                String n_nombre1 = result.getString(2);
                String n_apellido1 = result.getString(3);
                Cliente c = new Cliente(k_cliente, n_nombre1, n_apellido1);
                clientes.add(c);
                System.out.println("CLIENTE "+ c.getK_CLIENTE());
            }
            
           
        } catch (SQLException ex) {
            System.out.println("ERROR EN GETCLIENTES: "+ ex);
           
        }
         
         return clientes;
    }

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
        String sqlRepresentante = "INSERT INTO NATAME.REPRESENTANTE_VENTAS VALUES('" + representante.getK_REPRESENTANTE()+ "','" +representante.getK_REPRESENTANTE_SUPERIOR() + "','" + representante.getK_REGION() + "','" + representante.getK_PAIS() + "','"  +representante.getN_NOMBRE1() + "','" + representante.getN_NOMBRE2() + "','" + representante.getN_APELLIDO1() + "','" + representante.getN_APELLIDO2() + "','" + representante.getI_TIPO_DOCUMENTO() + "','" + representante.getN_DOCUMENTO() + "','" + representante.getN_DIRECCION() + "','" + representante.getN_CORREO() + "','" + representante.getI_GENERO()+ "', TO_DATE('" + representante.getF_NACIMIENTO() + "','YYYY-MM-DD'),'" + representante.getN_TELEFONO()  + "')";
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

    public static int[] getRegionPais(Connection conn, String k_representante) {
        
        int[] regional = {1, 1};
        try {
            String query="";
            if ("CLIENTE".equals(Conexion.tipo)){
                query = "SELECT * FROM CLIENTE c, REPRESENTANTE_vENTAS re, REFERIDO rf WHERE c.k_cliente = rf.k_cliente AND re.k_representante = rf.k_representante AND re.k_representante = '"+k_representante+"'";
            }
            if(Conexion.tipo.equals("REP_VENTA")){
                query = "SELECT K_REGION, K_PAIS FROM REPRESENTANTE_VENTAS WHERE K_REPRESENTANTE ='"+k_representante+"'";
            }
            
            
            
            PreparedStatement stPet =  conn.prepareStatement(query);
            ResultSet result = stPet.executeQuery();
            while(result.next()){
                regional[0] = result.getInt(1);
                regional[1] = result.getInt(2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepresentanteVentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return regional;
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
