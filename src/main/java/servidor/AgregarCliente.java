/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import DAO.ClienteDAO;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.modelos.Cliente;

/**
 *
 * @author asus
 */
public class AgregarCliente extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String K_CLIENTE = request.getParameter("K_CLIENTE");
        String N_NOMBRE1 = request.getParameter("N_NOMBRE1");
        String N_NOMBRE2 = request.getParameter("N_NOMBRE2");
        String N_APELLIDO1 = request.getParameter("N_APELLIDO1");
        String N_APELLIDO2 = request.getParameter("N_APELLIDO2");
        String I_TIPO_DOCUMENTO = request.getParameter("I_TIPO_DOCUMENTO");
        String N_DOCUMENTO = request.getParameter("N_DOCUMENTO");
        String N_DIRECCION = request.getParameter("N_DIRECCION");
        String N_CORREO = request.getParameter("N_CORREO");
        String I_GENERO = request.getParameter("I_GENERO");
        String F_NACIMIENTO = request.getParameter("F_NACIMIENTO");
        String fecha[] = F_NACIMIENTO.split("-");
        F_NACIMIENTO = fecha[2] + '-' + fecha[1] + '-' + fecha[0];

        System.out.println(K_CLIENTE);
        System.out.println(N_NOMBRE1);
        System.out.println(N_NOMBRE2);
        System.out.println(N_APELLIDO1);
        System.out.println(N_APELLIDO2);
        System.out.println(I_TIPO_DOCUMENTO);
        System.out.println(N_DOCUMENTO);
        System.out.println(N_DIRECCION);
        System.out.println(N_CORREO);
        System.out.println(I_GENERO);
        System.out.println(F_NACIMIENTO);

//        String user = request.getParameter("user");
//        String password = request.getParameter("password");
        Conexion c = new Conexion("natame", "natame1234"); //Provicionalmente pongo valores quemados, pero ya trae el user y password de un formualrio
        Connection connection = Conexion.getConnection();
        CallableStatement cs = null;

        //Se realiza la llamada a la funcion de BBDD que retornará un String
        cs = connection.prepareCall("{? = call FU_AGREGAR_CLIENTE(?,?,?,?,?,?,?,?,?,?,?)}");

        cs.registerOutParameter(1, Types.VARCHAR); //se indica el objeto de salida y la posición, en este caso un String.
        cs.setString(2, K_CLIENTE);
        cs.setString(3, N_NOMBRE1);
        cs.setString(4, N_NOMBRE2);
        cs.setString(5, N_APELLIDO1);
        cs.setString(6, N_APELLIDO2);
        cs.setString(7, I_TIPO_DOCUMENTO);
        cs.setString(8, N_DOCUMENTO);
        cs.setString(9, N_DIRECCION);
        cs.setString(10, N_CORREO);
        cs.setString(11, I_GENERO);
        cs.setString(12, F_NACIMIENTO);

        cs.execute(); //ejecuta la llamada y retorna un boolean, se puede usar también executeUpdate() que retorna un entero.

        //se recupera el resultado de la funcion pl/sql
        String retorno = cs.getString(1);

        if (retorno.equalsIgnoreCase("ok")) {
            PreparedStatement pstUser = null;
            String sqlUser = "CREATE USER " + K_CLIENTE + " IDENTIFIED BY " + K_CLIENTE + " DEFAULT TABLESPACE usernatdef temporary tablespace usernattmp quota 2m on usernatdef";
            System.out.println(sqlUser);
            pstUser = connection.prepareStatement(sqlUser);
            pstUser.execute();
            pstUser.close();
            
            PreparedStatement pstGrant = null;
            String sqlGrant = "GRANT R_CLIENTE TO "+K_CLIENTE;
            pstGrant = connection.prepareStatement(sqlGrant);
            pstGrant.execute();
            pstGrant.close();
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*ClienteDAO clienteDAO = new ClienteDAO();
        //Representante_Ventas representante = new Representante_Ventas(request.getParameter("K_USUARIO"), request.getParameter("K_REPRESENTANTE_SUPERIOR"), Integer.parseInt(request.getParameter("K_REGION")), Integer.parseInt(request.getParameter("K_PAIS")));
        Cliente cliente = new Cliente(request.getParameter("K_CLIENTE"), request.getParameter("N_NOMBRE1"), request.getParameter("N_NOMBRE2"), request.getParameter("N_APELLIDO1"), request.getParameter("N_APELLIDO2"), request.getParameter("I_TIPO_DOCUMENTO"), request.getParameter("N_DOCUMENTO"), request.getParameter("N_DIRECCION"), request.getParameter("N_CORREO"), request.getParameter("I_GENERO"), request.getParameter("F_NACIMIENTO"));

        String respuesta = clienteDAO.agregarCliente(co, cliente);
        //String respuesta="hOLI";
         */
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("[");
            out.println("{");
            out.println("\"respuesta\": \"" + retorno + '"');
            out.println("}");
            out.println("]");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
