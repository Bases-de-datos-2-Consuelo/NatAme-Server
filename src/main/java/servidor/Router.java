/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import DAO.PedidoDAO;
import DAO.RepresentanteVentasDAO;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.modelos.Cliente;
import negocio.modelos.Producto;

/**
 *
 * @author asus
 */
public class Router extends HttpServlet {

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
        String pagina = request.getParameter("pagina");
        switch (pagina) {
            case "crear-rep-venta":
                request.getRequestDispatcher("crear-rep-venta.jsp").forward(request, response);
                break;
            case "crear-cliente":
                request.getRequestDispatcher("crear-cliente.jsp").forward(request, response);
                break;
            case "crear-pedido":
                ArrayList<Producto> productos=PedidoDAO.getProductosporRegion(Conexion.user);
                ArrayList<Cliente> clientes = RepresentanteVentasDAO.getClientes(Conexion.user);
                request.setAttribute("productos", productos);
                request.setAttribute("clientes", clientes);
                request.setAttribute("usuario", Conexion.user);
                request.getRequestDispatcher("crear-pedido.jsp").forward(request, response);
                break;
            case "cerrar-sesion":                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "imprimir-factura":
                request.getRequestDispatcher("generarFactura.jsp").forward(request, response);
                break;
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
