/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.modelos.Pedido;
import negocio.modelos.Producto;

/**
 *
 * @author asus
 */
public class PedidoDAO {

    public static ArrayList<Producto> getProductos(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String mensaje = "";

    public PedidoDAO() {

    }

    public static ArrayList<Producto> getProductos() {
        String query = "SELECT * FROM PRODUCTO";
        ArrayList<Producto> resultado = new ArrayList<Producto>();

        Connection conn = Conexion.getConnection();
        try {
            PreparedStatement psQuery = conn.prepareStatement(query);
            ResultSet productos = psQuery.executeQuery();

            while (productos.next()) {
                int k_producto = productos.getInt(1);
                int k_categoria = productos.getInt(2);
                String n_nombre = productos.getString(3);
                String n_descripcion = productos.getString(4);
                Producto p = new Producto(k_producto, k_categoria, n_nombre, n_descripcion);

                resultado.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public static ArrayList<Producto> getProductosporRegion(String k_usuario){
        
        String query = null;
        if("CLIENTE".equals(UsuarioDAO.getTipoUsuario(k_usuario))){
            query = "SELECT * FROM PRODUCTO";
        }
        if("REP_VENTAS".equals(UsuarioDAO.getTipoUsuario(k_usuario))){
            query = "SELECT * FROM PRODUCTO p, INVENTARIO I, REPRESENTANTE_VENTAS r \n" +
                        "WHERE p.k_producto  = i.k_producto  AND\n" +
                        "i.k_region = r.k_region AND i.k_pais = r.k_pais\n" +
                        "AND r.k_representante = '"+k_usuario+"'";
        }
        
        ArrayList<Producto> resultado = new ArrayList<>();

        Connection conn = Conexion.getConnection();
        try {
            PreparedStatement psQuery = conn.prepareStatement(query);
            ResultSet productos = psQuery.executeQuery();

            while (productos.next()) {
                int k_producto = productos.getInt(1);
                int k_categoria = productos.getInt(2);
                String n_nombre = productos.getString(3);
                String n_descripcion = productos.getString(4);
                Producto p = new Producto(k_producto, k_categoria, n_nombre, n_descripcion);

                resultado.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public String guardarPedido(Connection conn, Pedido pedido, String[] productos, String tipo_pago, int region, int pais, String calificacion, String k_cliente) {

        PreparedStatement pstPedido = null;
        PreparedStatement pstProductos = null;

        String sqlPedido = "INSERT INTO NATAME.PEDIDO VALUES(NULL,CURRENT_DATE,'PENDIENTE', "+calificacion+", '"+k_cliente+"')";

        //System.out.println(sqlPedido);
        try {

            pstPedido = conn.prepareStatement(sqlPedido, new String[]{"K_PEDIDO"});
            pstPedido.execute();
            ResultSet generated = pstPedido.getGeneratedKeys();

            String sqlProducto = null;

            if (generated.next()) {
                int K_PEDIDO = generated.getInt(1);
                //System.out.println(K_PEDIDO + " " + productos.length);
                for (int i = 0; i < productos.length; i++) {

                    sqlProducto = "INSERT INTO NATAME.ITEM VALUES(" + K_PEDIDO + "," + productos[i] + ", " + region + "," + pais + ",2)";
                    pstProductos = conn.prepareStatement(sqlProducto);
                    pstProductos.execute();
                }
                pstProductos.close();
            } else {
                System.out.println("No entró al if");
            }
            pstPedido.close();
            return "Guardado correctamente.";

        } catch (SQLException e) {
            System.out.println("ERROR EN GUARDAR PEDIDO "+ e);
            return "ERROR EN GUARDAR PEDIDO " +e.getMessage();
        }

    }

    public String pagarPedido(Connection conn, Pedido pedido, String[] productos, String tipo_pago, String nota, String usua, int region, int pais, String calificacion, String k_cliente) {

        System.out.println("LLEGAN REGION  Y PAIS "+region +", " +pais);
        PreparedStatement pstPedido = null;
        PreparedStatement pstProductos = null;
        PreparedStatement pstActualizarPedido = null;
        PreparedStatement pstInventario = null;

        String sqlPedido = "INSERT INTO NATAME.PEDIDO VALUES(NULL,CURRENT_DATE,'PAGADO', "+calificacion+", '"+k_cliente+"')";
        //System.out.println(sqlPedido);
        try {

            pstPedido = conn.prepareStatement(sqlPedido, new String[]{"K_PEDIDO"});
            pstPedido.execute();
            ResultSet generated = pstPedido.getGeneratedKeys();

            String sqlProducto = null;
            String sqlInventario = null;
            if (generated.next()) {
                int K_PEDIDO = generated.getInt(1);
                for (int i = 0; i < productos.length; i++) {

                    sqlProducto = "INSERT INTO NATAME.ITEM VALUES(" + K_PEDIDO + "," + productos[i] + ", " + region + "," + pais + ",2)";
                    //System.out.println(sqlProducto);
                    pstProductos = conn.prepareStatement(sqlProducto);
                    pstProductos.execute();
                }
                
                
                Connection connection = Conexion.getConnection();
                CallableStatement cs = null;

            //Se realiza la llamada a la funcion de BBDD que retornará un String
                cs = connection.prepareCall("{? = call NATAME.FU_CALCULAR_TOTAL_PEDIDO(?)}");
                cs.registerOutParameter(1, Types.NUMERIC); //se indica el objeto de salida y la posición, en este caso un String.
                cs.setInt(2, K_PEDIDO);
                cs.execute(); 
                int retorno = cs.getInt(1);
                System.out.println("valor retorno "+retorno);
                String sqlPago = "INSERT INTO PAGO VALUES ("+K_PEDIDO+", CURRENT_DATE, '"+tipo_pago+"' , " +retorno+ ")";
        
                System.out.println(sqlPago);
                pstActualizarPedido = conn.prepareStatement(sqlPago);
                pstActualizarPedido.execute();
                pstActualizarPedido.close();

                pstProductos.close();
//                pstInventario.close();

            } else {
                System.out.println("No entró al if");
            }

            pstPedido.close();
            return "Pagado correctamente.";

        } catch (SQLException e) {
            System.out.println(e);
            return e.getMessage();
        }
    }
}
