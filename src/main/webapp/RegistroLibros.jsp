<%@page import="java.util.List"%>
<%@page import="DAO.DAOEditorial"%>
<%@page import="Model.CrudEditorial"%>
<script>
    function valida() {
        mensaje ="";
        nameL = document.getElementById("nameL").value;
        if(nameL ==""){
            mensaje = mensaje + " * Nombre del Libro sin datos \n";
        }
        stock = document.getElementById("stock").value;
        if(stock == ""){
            mensaje = mensaje + " * Stock sin datos \n";
        }
        cantAct = document.getElementById("cantAct").value;
        if(cantAct ==""){
            mensaje = mensaje + " * Cantidad Actual telefónico sin datos \n";
        }
        restEdad = document.getElementById("restEdad").value;
        if(restEdad ==""){
            mensaje = mensaje + " * Restricción de Edad sin datos \n";
        }
        editorial = document.getElementById("editorial").value;
        if(editorial ==""){
            mensaje = mensaje + " * Editorial sin datos \n";
        }   
        isbn = document.getElementById("isbn").value;
        if(isbn ==""){
            mensaje = mensaje + " * Código ISBN sin datos \n";
        }
        if(mensaje!=""){
            mensaje = "Datos faltantes en el formulario  \n \n" + mensaje;
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
            CrudEditorial ce = new CrudEditorial();
            List<DAOEditorial> editoriales = ce.Lista_editorial();
        %>
        
    <jsp:include page='html/menu.jsp'></jsp:include>

        <div style="display: grid; justify-content: center; align-items: center">
            <h1>Registro Libros</h1>
            <br>
            <form action="NewServletRegistroLibro" method="POST" onsubmit="return valida()">
                <table>
                    <tbody>
                        <tr>
                            <td><label for="name">Nombre Libro</label></td>
                            <td><input type="text" name="name" id="name" placeholder="La Odisea"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="stock">Stock</label></td>
                            <td><input type="number" name="stock" id="stock" placeholder="50"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="cantAct">Cantidad Actual</label></td>
                            <td><input type="number" name="cantAct" id="cantAct" placeholder="50"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="restEdad">Restricción de Edad</label></td>
                            <td><input type="number" name="restEdad" id="restEdad" placeholder="14"></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td><label for="editorial">Editorial </label></td>
                            <td><select name="editorial" required>
                                
                                <% for (DAOEditorial editorial : editoriales) { %>
                                    <option value="<%= editorial.getID_EDITORIAL() %>">
                                        <%= editorial.getVCH_NOMBRE_EDITORIAL() %>
                                    </option>
                                <% } %>
                                     
                            </select></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td><label for="autor">Código ISBN</label></td>
                            <td><input type="number" name="isbn" id="isbn" placeholder="41"></td>
                            <td></td>
                            <td></td>
                        </tr>  
                        <tr>
                            <td><br></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button class="btn btn-success" type="submit">REGISTRAR</button></td>
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
