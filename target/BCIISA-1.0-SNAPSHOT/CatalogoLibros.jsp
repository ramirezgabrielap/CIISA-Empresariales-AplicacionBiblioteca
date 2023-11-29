
<%@page import="DAO.DAOEditorial"%>
<%@page import="Model.CrudEditorial"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOLibro"%>
<%@page import="Model.CrudLibro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page='html/head.jsp'></jsp:include>

        <title>JSP Page</title>
    </head>
    <body>
    <jsp:include page='html/menu.jsp'></jsp:include>

        <%
            CrudLibro cl = new CrudLibro();
            List<DAOLibro> libros = cl.Lista();
            
            CrudEditorial ce = new CrudEditorial();

        %>
    
        <div style="display: grid; justify-content: center; align-items: center">
            <h1>Listado de Libros de BCIISA</h1>
            <br>
            
                
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
