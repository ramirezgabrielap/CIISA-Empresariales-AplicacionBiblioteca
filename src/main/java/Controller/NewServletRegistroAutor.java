package Controller;


import DAO.DAOAutor;
import Model.CrudAutor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewServletRegistroAutor extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje ="";
        String insertaAutor;
        
        try {
            DAOAutor autor = validacionUsuario(request);
            CrudAutor cp = new CrudAutor();
            insertaAutor = cp.Create(autor);
            mensaje += insertaAutor;
            
            if (Integer.parseInt(insertaAutor) != 0) {
                mensaje = "Autor grabado con Éxito";
            }     
        } catch (NumberFormatException ex) {
            mensaje = ex.getMessage();
        }
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        //response.sendRedirect("home.jsp");
    }

    protected DAOAutor validacionUsuario(HttpServletRequest request){
        DAOAutor autor = new DAOAutor();
        String nombre = request.getParameter("nameA");
        
        if (autor.ValidaSubida(nombre)){
            return autor;
        } else {
            return new DAOAutor();
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
            Logger.getLogger(NewServletRegistroAutor.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewServletRegistroAutor.class.getName()).log(Level.SEVERE, null, ex);
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
