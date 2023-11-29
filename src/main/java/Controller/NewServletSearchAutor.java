package Controller;

import DAO.DAOAutor;
import Model.CrudAutor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletSearchAutor extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String parametro = request.getParameter("searchautor");
        CrudAutor autor = new CrudAutor();
        List<DAOAutor> listaAutor = autor.Read_Search(parametro);
        
        String elementos = "";
        if(!listaAutor.isEmpty()){
            for(int i = 0; i<listaAutor.size(); i++){
                elementos += elementBuilder(listaAutor.get(i));
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
            );            request.getRequestDispatcher("SearchAutor.jsp").forward(request, response);
        } else {
            String mensaje = "<div><label><b>No se han encontrado elementos para la búsqueda: "+parametro+"</b></label></div>";
            request.setAttribute("respuesta", mensaje);
            request.getRequestDispatcher("SearchAutor.jsp").forward(request, response);
        }
    }

    protected String elementBuilder(DAOAutor autor){
        String elemento = 
        "<tr>" +
            "<td>"+autor.getID_AUTOR()+"</td>" +
            "<td>"+autor.getVCH_NOMBRE_AUTOR()+"</td>" +
            "<td>" +
                "<form action=UpdateAutor.jsp method=POST>" + 
                    "<input type=hidden id=idautor name=idautor value="+autor.getID_AUTOR()+">" + 
                    "<button class='btn btn-sm btn-outline-warning'><i class=\"bi bi-pencil-fill\"></i> Editar </button>" +
                "</form>" +
            "</td>" +
            "<td>" +
                "<form action=DeleteAutor.jsp method=POST>" + 
                    "<input type=hidden id=idautor name=idautor value="+autor.getID_AUTOR()+">" +
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
