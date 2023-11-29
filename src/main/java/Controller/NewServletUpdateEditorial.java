package Controller;

import DAO.DAOEditorial;
import Model.CrudEditorial;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletUpdateEditorial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje = "";
        String EditEditorial;
        
        try {
            DAOEditorial editorial = validacion(request);
            CrudEditorial cp = new CrudEditorial();
            EditEditorial = cp.Update(editorial);
            mensaje += EditEditorial;
            
            if (Integer.parseInt(EditEditorial) != 0){
                mensaje = "Editorial Actualizada con éxito";
            }
        } catch (NumberFormatException ex){
            mensaje = ex.getMessage();
        }
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("SearchEditorial.jsp").forward(request, response);
    }
    
    protected DAOEditorial validacion(HttpServletRequest request){
	DAOEditorial editorial = new DAOEditorial();
	int id = Integer.parseInt(request.getParameter("ideditorial"));
	String nombre = request.getParameter("nameE");

	if(editorial.ValidaSubida(id, nombre)){
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
