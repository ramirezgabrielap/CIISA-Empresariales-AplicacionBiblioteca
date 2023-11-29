package Controller;

import DAO.DAOEditorial;
import Model.CrudEditorial;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewServletRegistroEditorial extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje ="";
        String insertaEditorial;
        
        try {
            DAOEditorial editorial = validacionUsuario(request);
            CrudEditorial cp = new CrudEditorial();
            insertaEditorial = cp.Create(editorial);
            mensaje += insertaEditorial;
            
            if (Integer.parseInt(insertaEditorial) != 0) {
                mensaje = "Editorial grabada con Éxito";
            }     
        } catch (NumberFormatException ex) {
            mensaje = ex.getMessage();
        }
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        //response.sendRedirect("home.jsp");
    }

    protected DAOEditorial validacionUsuario(HttpServletRequest request){
        DAOEditorial editorial = new DAOEditorial();
        String nombre = request.getParameter("nameE");
        
        if (editorial.ValidaSubida(nombre)){
            return editorial;
        } else {
            return new DAOEditorial();
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
            Logger.getLogger(NewServletRegistroEditorial.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewServletRegistroEditorial.class.getName()).log(Level.SEVERE, null, ex);
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
