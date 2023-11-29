package Controller;

import DAO.DAOEditorial;
import DAO.DAOLibro;
import Model.CrudEditorial;
import Model.CrudLibro;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewServletRegistroLibro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje ="";
        String insertaLibro;
        
        try {
            DAOLibro libro = validaLibro(request);
            CrudLibro cp = new CrudLibro();
            
            DAOLibro isbnExiste = cp.Read_libro_isbn(libro.getINT_CODIGO_ISBN());
            if(isbnExiste.getID_LIBRO() == 0){
                insertaLibro = cp.Create(libro);
                mensaje += insertaLibro;

                if (Integer.parseInt(insertaLibro) != 0) {
                    mensaje = "Libro grabado con Éxito";
                }
            } else {
                mensaje = "Ya existe un Libro con el ISBN"; 
            }
            
        } catch (NumberFormatException ex) {
            mensaje = ex.getMessage();
        }
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        //response.sendRedirect("home.jsp");
        
    }

    protected DAOLibro validaLibro(HttpServletRequest request){
        DAOLibro libro = new DAOLibro();
        
        libro.setVCH_NOMBRE_LIBRO(request.getParameter("name"));
        
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        libro.setINT_STOCK(stock);
        
        Integer cantAct = Integer.parseInt(request.getParameter("cantAct"));
        libro.setINT_CANT_ACT(cantAct);
        
        Integer restEdad = Integer.parseInt(request.getParameter("restEdad"));
        libro.setINT_RESTRICCION_EDAD(restEdad);
        
        libro.setVCH_RUT("1-9");
        
        Integer editorial = Integer.parseInt(request.getParameter("editorial"));
        libro.setID_EDITORIAL(editorial);
        
        Integer isbn = Integer.parseInt(request.getParameter("isbn"));
        libro.setINT_CODIGO_ISBN(isbn);
        
        if (libro.ValidaSubida(libro)){
            return libro;
        } else {
            return new DAOLibro();
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
            Logger.getLogger(NewServletRegistroLibro.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewServletRegistroLibro.class.getName()).log(Level.SEVERE, null, ex);
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
