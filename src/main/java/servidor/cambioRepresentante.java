/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luisy
 */
@WebServlet(name = "cambioRepresentante", urlPatterns = {"/cambioRepresentante"})
public class cambioRepresentante extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        String mensaje = "";

        try {
            
            
            String k_representante  = request.getParameter("K_REPRESENTANTE");
            String sqlupdate = "UPDATE REFERIDO SET F_FINAL = CURRENT_DATE WHERE K_REPRESENTANTE = '"+k_representante+"' AND K_CLIENTE = '"+Conexion.user+"' AND F_FINAL IS NULL ";
            String sqlinsert = "INSERT INTO REFERIDO VALUES('"+k_representante+"', '"+Conexion.user+"', CURRENT_DATE+1, NULL)";
            PreparedStatement update = Conexion.getConnection().prepareStatement(sqlupdate);
            update.execute();
            
            PreparedStatement insert = Conexion.getConnection().prepareStatement(sqlinsert);
            insert.execute();
            request.setAttribute("Cambio de representante exitoso!",mensaje);
            request.getRequestDispatcher("cambio-representante.jsp").forward(request, response);
            
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet cambioRepresentante</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet cambioRepresentante at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (SQLException ex) {
            mensaje=ex.getMessage();
            request.setAttribute("mensaje",mensaje);
            request.getRequestDispatcher("cambio-representante.jsp").forward(request, response);
            Logger.getLogger(cambioRepresentante.class.getName()).log(Level.SEVERE, null, ex);
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
