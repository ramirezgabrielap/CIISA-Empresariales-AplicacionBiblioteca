package Controller;

import DAO.DAOLibro;
import Model.CrudAutor;
import Model.CrudLibro;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletDeleteAutor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id_autor = Integer.parseInt(request.getParameter("idautor"));
        String mensaje="";
        
        CrudAutor cs = new CrudAutor();
        CrudLibro cl = new CrudLibro();
        
        List<DAOLibro> libros = cl.Read_Search_IDAutor(id_autor);
        for (DAOLibro libro : libros) {
            //borrar en tabla TBL_LIBRO_AUTOR
            cl.DeleteAutorLibro(libro.getID_LIBRO());
            //borrar en tabla TBL_LIBRO
            cl.Delete(libro.getID_LIBRO());
        }   
        
        mensaje += cs.Delete(id_autor);
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("SearchAutor.jsp").forward(request, response);
   
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
