<%@page import="DAO.DAOLibro"%>
<%@page import="java.util.List"%>
<%@page import="Model.CrudLibro"%>
<%@page import="DAO.DAOEditorial"%>
<%@page import="Model.CrudEditorial"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page='html/head.jsp'></jsp:include>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int ideditorial = Integer.parseInt(request.getParameter("ideditorial"));
            CrudEditorial ce = new CrudEditorial();
            DAOEditorial editorial = ce.Read_editorial(ideditorial);
            
            CrudLibro cl = new CrudLibro();
            List<DAOLibro> libros = cl.Read_Search_IDEditorial(ideditorial);
            
        %>
        <jsp:include page='html/menu.jsp'></jsp:include>

        <div style="display: grid; justify-content: center; align-items: center">
            <form action="NewServletDeleteEditorial" method="POST" onsubmit="return valida()">
                <h1>Eliminar Editorial</h1>
                <br>
                <br>
                <table class="table table-bordered table-hover shadow">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= editorial.getID_EDITORIAL() %></td>
                            <td><%= editorial.getVCH_NOMBRE_EDITORIAL() %></td>
                        </tr>
                    </tbody>
                </table>
                            
                <br>                            
                <br>
                
  
                <td><input type=hidden id=ideditorial name=ideditorial value="<%= ideditorial %>"></td>
                <td><button class="btn btn-danger" type="submit"><i class="bi bi-trash"></i> Confirmar Eliminación</button></td>
                
            </form> 
            
                <br><br>
            <h4>Libros asociados a la eliminación</h4>
                
            <table class="table table-bordered table-hover shadow">
                <thead class="thead-dark">
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Stock</th>
                        <th>Cantidad</th>
                        <th>Rest. Edad</th>
                        <th>ISBN</th>
                        <th>Editorial</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (DAOLibro libro : libros) { %>
                        <tr>
                            <td><%= libro.getID_LIBRO() %></td>
                            <td><%= libro.getVCH_NOMBRE_LIBRO() %></td>
                            <td><%= libro.getINT_STOCK() %></td>
                            <td><%= libro.getINT_CANT_ACT() %></td>
                            <td><%= libro.getINT_RESTRICCION_EDAD() %></td>
                            <td><%= libro.getINT_CODIGO_ISBN() %></td>
                            <td><%= ce.Read_editorial(libro.getID_EDITORIAL()).getVCH_NOMBRE_EDITORIAL() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
                
                
        </div>
    </body>
</html>
