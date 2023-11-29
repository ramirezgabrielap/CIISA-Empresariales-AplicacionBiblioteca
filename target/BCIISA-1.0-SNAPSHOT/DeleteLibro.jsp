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
        <%
            int idlibro = Integer.parseInt(request.getParameter("idlibro"));
            CrudLibro cp = new CrudLibro();
            DAOLibro libro = cp.Read_libro(idlibro);
        %>
        <jsp:include page='html/menu.jsp'></jsp:include>

        <div style="display: grid; justify-content: center; align-items: center">
            <form action="NewServletDeleteLibro" method="POST" onsubmit="return valida()">
                <h1>Eliminar Libro</h1>
                <br>
                <br>
                <table class="table table-bordered table-hover shadow">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID Libro</th>
                            <th>Nombre del Libro</th>
                            <th>Stock</th>
                            <th>Cantidad</th>
                            <th>Restricción Edad</th>
                            <th>ID Editorial</th>
                            <th>Código ISBN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= libro.getID_LIBRO() %></td>
                            <td><%= libro.getVCH_NOMBRE_LIBRO() %></td>
                            <td><%= libro.getINT_STOCK() %></td>
                            <td><%= libro.getINT_CANT_ACT() %></td>
                            <td><%= libro.getINT_RESTRICCION_EDAD() %></td>
                            <td><%= libro.getID_EDITORIAL() %></td>
                            <td><%= libro.getINT_CODIGO_ISBN() %></td>
                        </tr>
                    </tbody>
                </table>
                        
                    <br>
                    <br>
                    
                    <td><input type=hidden id=idlibro name=idlibro value="<%= idlibro %>"></td>
                    <button class="btn btn-danger" type="submit"><i class="bi bi-trash"></i> Confirmar Eliminación</button>
            </form>  
        </div>
    </body>
</html>
