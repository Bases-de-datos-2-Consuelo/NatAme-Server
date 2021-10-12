/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import DAO.RepresentanteVentasDAO;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.modelos.Representante_Ventas;
import negocio.modelos.Usuario;

/**
 *
 * @author asus
 */
public class AgregarRepresentante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String K_REPRESENTANTE = request.getParameter("K_REPRESENTANTE");
        int[] REGIONAL;
        try {
            REGIONAL = RepresentanteVentasDAO.getRegionPais(Conexion.getConnection(), Conexion.user);

            String K_REPRESENTANTE_SUPERIOR = Conexion.user;
            String N_NOMBRE1 = request.getParameter("N_NOMBRE1");
            String N_NOMBRE2 = request.getParameter("N_NOMBRE2");
            String N_APELLIDO1 = request.getParameter("N_APELLIDO1");
            String N_APELLIDO2 = request.getParameter("N_APELLIDO2");
            String I_TIPO_DOCUMENTO = request.getParameter("I_TIPO_DOCUMENTO");
            String Q_DOCUMENTO = request.getParameter("Q_DOCUMENTO");
            String N_DIRECCION = request.getParameter("N_DIRECCION");
            String N_CORREO = request.getParameter("N_CORREO");
            String I_GENERO = request.getParameter("I_GENERO");
            String F_NACIMIENTO = request.getParameter("F_NACIMIENTO");
            String fecha[] = F_NACIMIENTO.split("-");
            F_NACIMIENTO = fecha[2] + '-' + fecha[1] + '-' + fecha[0];
            String N_TELEFONO = request.getParameter("N_TELEFONO");
            System.out.println(K_REPRESENTANTE);
            System.out.println(REGIONAL[0]);
            System.out.println(REGIONAL[1]);
            System.out.println(K_REPRESENTANTE_SUPERIOR);
            System.out.println(N_NOMBRE1);
            System.out.println(N_NOMBRE2);
            System.out.println(N_APELLIDO1);
            System.out.println(N_APELLIDO2);
            System.out.println(I_TIPO_DOCUMENTO);
            System.out.println(Q_DOCUMENTO);
            System.out.println(N_DIRECCION);
            System.out.println(N_CORREO);
            System.out.println(I_GENERO);
            System.out.println(F_NACIMIENTO);
            System.out.println(N_TELEFONO);

            // response.sendRedirect("https://www.it-swarm-es.com/es/java/llamar-una-funcion-de-oracle-desde-java/1068792680/");
            //String user = request.getParameter("user");
            //String password = request.getParameter("password");
            //Conexion c = new Conexion("natame", "natame1234"); //Provicionalmente pongo valores quemados, pero ya trae el user y password de un formualrio
            Connection connection = Conexion.getConnection();
            CallableStatement cs = null;

            //Se realiza la llamada a la funcion de BBDD que retornará un String
            cs = connection.prepareCall("{? = call NATAME.PK_NATAME.FU_AGREGAR_REPVENTA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            cs.registerOutParameter(1, Types.VARCHAR); //se indica el objeto de salida y la posición, en este caso un String.
            cs.setString(2, K_REPRESENTANTE);
            cs.setInt(3, REGIONAL[0]);
            cs.setInt(4, REGIONAL[1]);
            cs.setString(5, K_REPRESENTANTE_SUPERIOR);
            cs.setString(6, N_NOMBRE1);
            cs.setString(7, N_NOMBRE2);
            cs.setString(8, N_APELLIDO1);
            cs.setString(9, N_APELLIDO2);
            cs.setString(10, I_TIPO_DOCUMENTO);
            cs.setString(11, Q_DOCUMENTO);
            cs.setString(12, N_DIRECCION);
            cs.setString(13, N_CORREO);
            cs.setString(14, I_GENERO);
            cs.setString(15, F_NACIMIENTO);
            cs.setString(16, N_TELEFONO);

            cs.execute(); //ejecuta la llamada y retorna un boolean, se puede usar también executeUpdate() que retorna un entero.

            //se recupera el resultado de la funcion pl/sql
            String retorno = cs.getString(1);
            System.out.println("RETORNO " + retorno);
            if (retorno.equalsIgnoreCase("ok")) {
                PreparedStatement pstUser = null;
                String sqlUser = "CREATE USER " + K_REPRESENTANTE + " IDENTIFIED BY " + K_REPRESENTANTE + " DEFAULT TABLESPACE usernatdef temporary tablespace usernattmp quota 2m on usernatdef";
                System.out.println(sqlUser);
                pstUser = connection.prepareStatement(sqlUser);
                pstUser.execute();
                pstUser.close();

                PreparedStatement pstGrant = null;
                String sqlGrant = "GRANT R_REPRESENTANTEVENTA,R_CLIENTE TO " + K_REPRESENTANTE + " WITH ADMIN OPTION";
                pstGrant = connection.prepareStatement(sqlGrant);
                pstGrant.execute();
                pstGrant.close();
                request.setAttribute("mensaje", retorno);
                request.getRequestDispatcher("crear-rep-venta.jsp").forward(request, response);

            } else {
                request.setAttribute("mensaje", retorno);
                request.getRequestDispatcher("crear-rep-venta.jsp").forward(request, response);
            }
        } catch (SQLException ex) { 

            request.setAttribute("mensaje", ex.getMessage());
            request.getRequestDispatcher("crear-rep-venta.jsp").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

}
