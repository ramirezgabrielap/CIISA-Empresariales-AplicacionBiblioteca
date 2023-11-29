package Controller;

import DAO.DAOLibro;
import Model.CrudLibro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServletUpdateLibro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje = "";
        String EditLibro;

        try {
            DAOLibro libro = validacion(request);
            CrudLibro cl = new CrudLibro();
            
            DAOLibro isbnExiste = cl.Read_libro_isbn(libro.getINT_CODIGO_ISBN());
            DAOLibro libroDB = cl.Read_libro(libro.getID_LIBRO());
            
            //idLibvro = 0 objecto vacio (new)     ||   ibn es igual al isbn que tiene el libro en la base
            if(isbnExiste.getID_LIBRO() == 0 || libro.getINT_CODIGO_ISBN() == libroDB.getINT_CODIGO_ISBN() ){
                EditLibro = cl.Update(libro);
                System.out.println("###############################");
                System.out.println(EditLibro);
                
                if (Integer.parseInt(EditLibro) != 0){
                    mensaje = "Libro Actualizado con éxito";
                }
            } else {
                mensaje = "Ya existe un Libro con el ISBN"; 
            }
            
        } catch (NumberFormatException ex){
            System.out.println("ERRO ((((((((((((((((((((((((((((((((:"+ ex.getMessage());
            mensaje = ex.getMessage();
        }
        
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("SearchLibro.jsp").forward(request, response);
    }

    protected DAOLibro validacion(HttpServletRequest request){
        DAOLibro libro = new DAOLibro();
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        libro.setID_LIBRO(id);
        
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
