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

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Conexion c = new Conexion("natame", "natame1234"); //Provicionalmente pongo valores quemados, pero ya trae el user y password de un formualrio
        Connection co = c.getConnection();

        RepresentanteVentasDAO representanteDAO = new RepresentanteVentasDAO();
        Representante_Ventas representante = new Representante_Ventas(request.getParameter("K_USUARIO"), request.getParameter("K_REPRESENTANTE_SUPERIOR"), Integer.parseInt(request.getParameter("K_REGION")), Integer.parseInt(request.getParameter("K_PAIS")));
        Usuario usuario = new Usuario(request.getParameter("K_USUARIO"), request.getParameter("N_NOMBRE1"), request.getParameter("N_NOMBRE2"), request.getParameter("N_APELLIDO1"), request.getParameter("N_APELLIDO2"), request.getParameter("I_TIPO_DOCUMENTO"), request.getParameter("N_DOCUMENTO"), request.getParameter("N_DIRECCION"), request.getParameter("N_CORREO"), request.getParameter("I_GENERO"), request.getParameter("F_NACIMIENTO"), request.getParameter("N_TELEFONO"));

        String respuesta = representanteDAO.agregarRepresentante(co, representante, usuario);
        //String respuesta="hOLI";
        /*
        
       String respuesta="hOLA";*/
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("[");
            out.println("{");
            out.println("\"respuesta\": \"" + respuesta + '"');
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
