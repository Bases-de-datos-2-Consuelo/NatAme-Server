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
import java.sql.Statement;
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

                    sqlInventario = "UPDATE inventario i SET i.Q_STOCK =i.Q_STOCK - 2 WHERE i.K_PRODUCTO=2 AND i.K_REGION="+region+" AND i.K_PAIS ="+pais+"";

//                    pstInventario = conn.prepareStatement(sqlInventario);
//                    pstInventario.execute();
                }
                
                String sqlPago = "INSERT INTO PAGO VALUES ("+K_PEDIDO+", CURRENT_DATE, "+tipo_pago+" , 0.1)";
                String sqlPago2 = "UPDATE PAGO "
                        + "SET V_TOTAL=(SELECT sum(i.Q_CANTIDAD *p.V_VALOR ) TOTAL FROM item i,PRODUCTO p"
                        + "			WHERE i.K_PRODUCTO=p.K_PRODUCTO "
                        + "			),"
                        //+ "I_ESTADO='PAGADO',"
                        //+ "I_TIPO_PAGO='" + tipo_pago + "',"
                        //+ "Q_CALIFICACION=" + Integer.parseInt(nota) + ","
                        + "F_FECHA_REALIZADO= CURRENT_DATE "
                        //+ "K_REALIZADO_PARA=" + usua + "'"
                        + "WHERE K_PEDIDO =" + K_PEDIDO;
                //System.out.println(sqlPago);
                pstActualizarPedido = conn.prepareStatement(sqlPago);
                pstActualizarPedido.execute();
                pstActualizarPedido.close();
                pstActualizarPedido = conn.prepareStatement(sqlPago2);
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
