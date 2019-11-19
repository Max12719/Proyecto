/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LAB-USR-PT116-E305
 */
public class Validar1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EmpleadoDAO edao=new EmpleadoDAO();
    Empleado em=new Empleado();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {//agregue nuevo
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            em=edao.validar(user, pass);
            if(em.getUser()!=null){
               Empleado empleado;
               empleado = edao.Buscartipo(user, pass);
                
                request.getSession().setAttribute("usuario", empleado);
                request.setAttribute("usuario", em);
                request.getRequestDispatcher("Controlador1?menu=Principal").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
            Logger.getLogger(Validar1.class.getName()).log(Level.SEVERE, null, ex);
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
            /*String accion=request.getParameter("accion");
            if(accion.equalsIgnoreCase("Ingresar")){
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            em=edao.validar(user, pass);
            if(em.getUser()!=null){
            request.setAttribute("usuario", em);
            request.getRequestDispatcher("Controlador1?accion=Principal").forward(request, response);
            }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            }
            else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Validar1.class.getName()).log(Level.SEVERE, null, ex);
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
