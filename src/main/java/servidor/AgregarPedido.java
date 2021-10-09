 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import DAO.PedidoDAO;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.modelos.Pedido;

/**
 *
 * @author asus
 */
public class AgregarPedido extends HttpServlet {

    String respuesta = null;

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

//        String user = request.getParameter("user");
//        String password = request.getParameter("password");
//        user="natame";
//        password="natame1234";
        //Conexion c = new Conexion("admin1", "admin1"); //Provicionalmente pongo valores quemados, pero ya trae el user y password de un formualrio
//        Conexion.user=user;
//        Conexion.password=password;
/*        Connection co = Conexion.getConnection();

        String[] productos = request.getParameterValues("K_PRODUCTO");
        String estado = request.getParameter("ESTADO_PEDIDO");
        String tipo_pago = request.getParameter("I_TIPO_PAGO");
        String calificacion = request.getParameter("Q_CALIFICACION");
        String regional = request.getParameter("K_REGION");
        String pais = request.getParameter("K_PAIS");

        Pedido pedido = new Pedido();
        PedidoDAO pedDAO = new PedidoDAO();

        if (estado.equals("GUARDAR")) {
            respuesta = pedDAO.guardarPedido(co, pedido, productos,tipo_pago, regional, pais);

        } else {
            respuesta = pedDAO.pagarPedido(co, pedido, productos, tipo_pago, calificacion, Conexion.user, regional, pais);
        }
*/
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("[");
            out.println("{");
            out.println("\"respuesta\": \"" + "respuesta" + '"');
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
