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
    private static String user = "natame";
    private static String password = "natame1234";
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    
    public Conexion(String user, String password){
        this.user=user;
        this.password=password;
    }

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            //conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Conexión no exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e);
        }

        return conn;
    }

    public void desconexion() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar" + e.getMessage());
        }

    }

}
