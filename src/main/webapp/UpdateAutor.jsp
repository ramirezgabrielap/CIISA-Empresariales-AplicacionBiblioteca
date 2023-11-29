<%@page import="DAO.DAOAutor"%>
<%@page import="Model.CrudAutor"%>
<script>
    function valida() {
        mensaje = "";
        searchautor = document.getElementById("searchautor").value;
        if (searchautor == "") {
            mensaje = mensaje + "* Autor a buscar está en blanco \n";
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
                int idautor = Integer.parseInt(request.getParameter("idautor"));
                CrudAutor ce = new CrudAutor();
                DAOAutor autor = ce.Read_autor(idautor);            
        %>
        
        <jsp:include page='html/menu.jsp'></jsp:include>
        
   
        <div style="display: grid; justify-content: center; align-items: center">
            <form action="NewServletUpdateAutor" method="POST" onsubmit="return valida()">
                <h1>Actualizar Autores</h1>
                <br>
                <br>
                <table>
                    <tbody>
                        <tr>
                            <td><label for="nameA">Nombre del Autor</label></td>
                            <td><input type="text" name="nameA" id="nameA" value="<%out.print(autor.getVCH_NOMBRE_AUTOR());%>"></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="idautor" id="idautor" value="<%out.print(autor.getID_AUTOR());%>"></td>
                            <td><button type="submit" class="btn btn-success">ACTUALIZAR</button></td>
                        </tr>
                    </tbody>
                </table>
                <br>
            </form>  
        </div>
    </body>
</html>
