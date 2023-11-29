package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletLogin extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String user = request.getParameter("user");
            if (user.equals("")){
                out.println("No se ingresó datos para Usuario" + "<br>");
            }

            String passwd = request.getParameter("passwd");
            if (passwd.equals("")){
                out.println("No se ingresó datos para CONTRASEÑA" + "<br>");
            } 
  
            String perfil = request.getParameter("perfil");
            if (perfil.equals("")){
                out.println("No se ingresó datos para CONTRASEÑA" + "<br>");
            } 
            
            out.println("<br>");
            if(user.equals("") || passwd.equals("") || perfil.equals("")){
                out.println("faltan datos por ingresar");
            } else {
                out.println(user + passwd + perfil);
                out.println("<br>" + "Bienvenido :) ");
            }
            
            //out.println("<a href=\"home.jsp\">HOME</a>");
            response.sendRedirect("home.jsp");
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
