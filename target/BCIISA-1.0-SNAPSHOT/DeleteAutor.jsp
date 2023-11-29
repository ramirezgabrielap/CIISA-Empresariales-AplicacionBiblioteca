
<%@page import="DAO.DAOLibro"%>
<%@page import="java.util.List"%>
<%@page import="Model.CrudLibro"%>
<%@page import="DAO.DAOAutor"%>
<%@page import="Model.CrudAutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page='html/head.jsp'></jsp:include>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int idautor = Integer.parseInt(request.getParameter("idautor"));
            CrudAutor ca = new CrudAutor();
            DAOAutor autor = ca.Read_autor(idautor);
            
            CrudLibro cl = new CrudLibro();
            List<DAOLibro> libros = cl.Read_Search_IDAutor(idautor);    

        %>
        <jsp:include page='html/menu.jsp'></jsp:include>
        
        <div style="display: grid; justify-content: center; align-items: center">
            <form action="NewServletDeleteAutor" method="POST" onsubmit="return valida()">
                <h1>Eliminar Autor</h1>
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
                            <td><%= autor.getID_AUTOR() %></td>
                            <td><%= autor.getVCH_NOMBRE_AUTOR() %></td>
                        </tr>
                    </tbody>
                </table>

                        
                        <br>
                        <br>
                        
                <td><input type=hidden id=idautor name=idautor value="<%out.print(idautor); %>"></td>
                <td><button class="btn btn-danger" type="submit">Confirmar Eliminación</button></form></td>

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
                        </tr>
                    <% } %>
                </tbody>
            </table>
            
            
            
        </div>
    </body>
</html>
