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
import java.sql.Connection;
import java.sql.SQLException;
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
        String K_REGION = request.getParameter("K_REGION");
        String K_PAIS = request.getParameter("K_PAIS");
        String K_REPRESENTANTE_SUPERIOR = request.getParameter("K_REPRESENTANTE_SUPERIOR");
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
        String N_TELEFONO = request.getParameter("N_TELEFONO");
        System.out.println(K_REPRESENTANTE);
        System.out.println(K_REGION);
        System.out.println(K_PAIS);
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
//        String user = request.getParameter("user");
//        String password = request.getParameter("password");
//        Conexion c = new Conexion("natame", "natame1234"); //Provicionalmente pongo valores quemados, pero ya trae el user y password de un formualrio
        /*Connection co = Conexion.getConnection();

        RepresentanteVentasDAO representanteDAO = new RepresentanteVentasDAO();
        Representante_Ventas representante = new Representante_Ventas(request.getParameter("K_REPRESENTANTE"), request.getParameter("K_REPRESENTANTE_SUPERIOR"), Integer.parseInt(request.getParameter("K_REGION")), Integer.parseInt(request.getParameter("K_PAIS")), request.getParameter("N_NOMBRE1"), request.getParameter("N_NOMBRE2"), request.getParameter("N_APELLIDO1"), request.getParameter("N_APELLIDO2"), request.getParameter("I_TIPO_DOCUMENTO"), request.getParameter("N_DOCUMENTO"), request.getParameter("N_DIRECCION"), request.getParameter("N_CORREO"), request.getParameter("I_GENERO"), request.getParameter("F_NACIMIENTO"), request.getParameter("N_TELEFONO"));
        //Usuario usuario = new Usuario(request.getParameter("K_USUARIO"), request.getParameter("N_NOMBRE1"), request.getParameter("N_NOMBRE2"), request.getParameter("N_APELLIDO1"), request.getParameter("N_APELLIDO2"), request.getParameter("I_TIPO_DOCUMENTO"), request.getParameter("N_DOCUMENTO"), request.getParameter("N_DIRECCION"), request.getParameter("N_CORREO"), request.getParameter("I_GENERO"), request.getParameter("F_NACIMIENTO"), request.getParameter("N_TELEFONO"));

        String respuesta;
        try {
            respuesta = representanteDAO.agregarRepresentante(co, representante);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarRepresentante.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String respuesta="hOLI";
        /*
        //
       String 
        respuesta="hOLA";*/
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("[");
            out.println("{");
            out.println("\"respuesta\": \"" + "Hola mundo desde Agregar representante de ventas" + '"');
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
        processRequest(request, response);
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
        processRequest(request, response);
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
