/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class Conexion {

    private static Connection conn = null;
    public static String user = "natame";
    public static String password = "natame1234";
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static Integer n;
    public static String tipo;
    
    public Conexion(String user, String password, String tipo){
        this.user=user;
        this.password=password;
        this.tipo = tipo;
    }

    public static Connection getConnection() {
        try {
            
            conn=null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            //conn.setAutoCommit(false);
            if (conn != null) {
                n=1;
                System.out.println("Conectado con: "+user+"-"+password +"("+tipo+")");
            } else {
                n=0;
                conn=null;
                System.out.println("Conexión no exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            n=0;
            conn=null;
            System.out.println(e);
        }

        return conn;
    }

    public static void desconexion() {
        try {
            n=0;
            conn.close();
            conn=null;
            System.out.println("Conexión terminada");
        } catch (Exception e) {
            conn=null;
            System.out.println("Error al desconectar" + e.getMessage());
        }

    }

}
