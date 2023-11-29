<%@page import="java.util.List"%>
<%@page import="DAO.DAOEditorial"%>
<%@page import="Model.CrudEditorial"%>
<%@page import="DAO.DAOLibro"%>
<%@page import="Model.CrudLibro"%>
<script>
    function valida() {
        mensaje = "";
        searchlibro = document.getElementById("searchlibro").value;
        if (searchlibro == "") {
            mensaje = mensaje + "* Libro a buscar está en blanco \n";
        }
        if (mensaje != "") {
            mensaje = "Datos faltantes en el formulario \n\n" + mensaje;
            alert(mensaje);
            return false;
        }
    }
            
</script>
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
                CrudLibro cl = new CrudLibro();
                DAOLibro libro = cl.Read_libro(idlibro);
                
                CrudEditorial ce = new CrudEditorial();
                List<DAOEditorial> editoriales = ce.Lista_editorial();
        %>
        
        <jsp:include page='html/menu.jsp'></jsp:include>

    
        <div style="display: grid; justify-content: center; align-items: center">
            <form action="NewServletUpdateLibro" method="POST" onsubmit="return valida()">
                <h1>Editar Libro</h1>

                <br>
                <br>

                <table>
                    <tbody>
                        <tr>
                            <td><label for="name">ID Libro</label></td>
                            <td><input type="text" name="idLibro" id="idLibro" value="<%= libro.getID_LIBRO() %>" disabled="disabled"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="name">Nombre Libro</label></td>
                            <td><input type="text" name="name" id="name" placeholder="La Odisea" value="<%= libro.getVCH_NOMBRE_LIBRO() %>"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="stock">Stock</label></td>
                            <td><input type="number" name="stock" id="stock" placeholder="50" value="<%= libro.getINT_STOCK() %>"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="cantAct">Cantidad Actual</label></td>
                            <td><input type="number" name="cantAct" id="cantAct" placeholder="50" value="<%= libro.getINT_CANT_ACT() %>"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="restEdad">Restricción de Edad</label></td>
                            <td><input type="number" name="restEdad" id="restEdad" placeholder="14" value="<%= libro.getINT_RESTRICCION_EDAD() %>"></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td><label for="editorial">Editorial <%= libro.getID_EDITORIAL() %></label></td>
                            <td><select name="editorial" required>
                                
                                <% for (DAOEditorial editorial : editoriales) { %>
                                    <option 
                                        value="<%= editorial.getID_EDITORIAL() %>" 
                                        <% if(libro.getID_EDITORIAL() == editorial.getID_EDITORIAL()) { %> selected <% } %>
                                    >
                                        <%= editorial.getVCH_NOMBRE_EDITORIAL() %>
                                    </option>
                                <% } %>
                                     
                            </select></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td><label for="autor">Código ISBN</label></td>
                            <td><input type="number" name="isbn" id="isbn" placeholder="41" value="<%= libro.getINT_CODIGO_ISBN() %>"></td>
                            <td></td>
                            <td></td>
                        </tr>  
                        <tr>
                            <td><br></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" id="id" value="<%= libro.getID_LIBRO() %>"></td>
                            <td><button class="btn btn-success" type="submit">Actualizar</button></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>

                </table>
                                
                <br>
                
            </form>  
        </div>
    </body>
</html>
