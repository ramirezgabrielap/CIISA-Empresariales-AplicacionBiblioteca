/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gaba
 */
public class NewServletRegistroCliente extends HttpServlet {

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
        
        try ( PrintWriter out = response.getWriter()) {
            
            String rut = request.getParameter("rut");
            if (rut.equals("")){
                out.println("No se ingresó datos para Rut" + "<br>");
            }

            String name = request.getParameter("name");
            if (name.equals("")){
                out.println("No se ingresó datos para Nombre" + "<br>");
            } 
  
            String phone_number = request.getParameter("phone_number");
            if (phone_number.equals("")){
                out.println("No se ingresó datos para Numero telefónico" + "<br>");
            } 
            
            String mail = request.getParameter("mail");
            if (mail.equals("")){
                out.println("No se ingresó datos para Correo" + "<br>");
            } 
            
            String nac = request.getParameter("nac");
            if (nac.equals("")){
                out.println("No se ingresó datos para Fecha Nacimiento" + "<br>");
            } 
            
            out.println("<br>");
            if(rut.equals("") || name.equals("") || phone_number.equals("") || mail.equals("") || nac.equals("")){
                out.println("faltan datos por ingresar");
            } else {
                out.println("RUT: " + rut + "<br>" + "NOMBRE: " + name + "<br>" + "FONO: " + phone_number + "<br>" + "CORREO: " + mail + "<br>" + "FECHA NAC: " + nac);
                out.println("<br>" + "<br>" + "Cliente Creado con éxito :) ");
            }
            
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
