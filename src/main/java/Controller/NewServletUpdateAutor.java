package Controller;

import DAO.DAOAutor;
import Model.CrudAutor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletUpdateAutor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje = "";
        String EditAutor;
        
        try {
            DAOAutor autor = validacion(request);
            CrudAutor cp = new CrudAutor();
            EditAutor = cp.Update(autor);
            mensaje += EditAutor;
            
            if (Integer.parseInt(EditAutor) != 0){
                mensaje = "Autor Actualizado con éxito";
            }
        } catch (NumberFormatException ex){
            mensaje = ex.getMessage();
        }
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("SearchAutor.jsp").forward(request, response);
    }

    protected DAOAutor validacion(HttpServletRequest request){
	DAOAutor autor = new DAOAutor();
	int id = Integer.parseInt(request.getParameter("idautor"));
	String nombre = request.getParameter("nameA");

	if(autor.ValidaSubida(id, nombre)){
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
