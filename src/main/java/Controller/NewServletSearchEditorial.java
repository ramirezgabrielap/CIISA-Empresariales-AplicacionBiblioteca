
package Controller;

import DAO.DAOEditorial;
import Model.CrudEditorial;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletSearchEditorial extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String parametro = request.getParameter("searchedit");
        CrudEditorial editorial = new CrudEditorial();
        List<DAOEditorial> listaEditorial = editorial.Read_Search(parametro);
        
        String elementos = "";
        if(!listaEditorial.isEmpty()){
            for(int i = 0; i<listaEditorial.size(); i++){
                elementos += elementBuilder(listaEditorial.get(i));
            }
            request.setAttribute("respuesta", 
                "<table class='table table-bordered table-hover shadow'>" +
                    "<thead class='thead-dark'>" +
                        "<tr>" +
                            "<th>Id</th>" +
                            "<th>Nombre</th>" +
                            "<th></th>" +
                            "<th></th>" +
                        "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                        elementos +
                    "</tbody>" +
                "</table>"
            );
            request.getRequestDispatcher("SearchEditorial.jsp").forward(request, response);
        } else {
            String mensaje = "<div><label><b>No se han encontrado elementos para la búsqueda: "+parametro+"</b></label></div>";
            request.setAttribute("respuesta", mensaje);
            request.getRequestDispatcher("SearchEditorial.jsp").forward(request, response);
        }
    }

    
    protected String elementBuilder(DAOEditorial editorial){
        String elemento = 
                "<tr>" +
                    "<td>"+editorial.getID_EDITORIAL()+"</td>" +
                    "<td>"+editorial.getVCH_NOMBRE_EDITORIAL()+"</td>" +
                    "<td>" +
                        "<form action=UpdateEditorial.jsp method=POST>" + 
                            "<input type=hidden id=ideditorial name=ideditorial value="+editorial.getID_EDITORIAL()+">" + 
                            "<button class='btn btn-sm btn-outline-warning'><i class=\"bi bi-pencil-fill\"></i> Editar </button>" +
                        "</form>" +
                    "</td>" +
                    "<td>" +
                        "<form action=DeleteEditorial.jsp method=POST>" + 
                            "<input type=hidden id=ideditorial name=ideditorial value="+editorial.getID_EDITORIAL()+">" +
                            "<button class='btn btn-sm btn-outline-danger'><i class=\"bi bi-trash-fill\"></i> Eliminar </button>" +
                        "</form>" +
                    "</td>" +
                "</tr>";

        return elemento;
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