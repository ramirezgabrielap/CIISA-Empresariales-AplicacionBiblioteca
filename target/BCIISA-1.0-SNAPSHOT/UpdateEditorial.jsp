<%@page import="DAO.DAOEditorial"%>
<%@page import="Model.CrudEditorial"%>
<script>
    function valida() {
        mensaje = "";
        searchedit = document.getElementById("searchedit").value;
        if (searchedit == "") {
            mensaje = mensaje + "* Editorial a buscar está en blanco \n";
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
        <jsp:include page='html/menu.jsp'></jsp:include>

        <%
                int ideditorial = Integer.parseInt(request.getParameter("ideditorial"));
                CrudEditorial ce = new CrudEditorial();
                DAOEditorial editorial = ce.Read_editorial(ideditorial);            
        %>
        

        <div style="display: grid; justify-content: center; align-items: center">
            <form action="NewServletUpdateEditorial" method="POST" onsubmit="return valida()">
                <h1>Actualizar Editoriales</h1>
                <br>
                <br>
                <table>
                    <tbody>
                        <tr>
                            <td><label for="nameE">Nombre de la Editorial</label></td>
                            <td><input type="text" name="nameE" id="nameE" value="<%out.print(editorial.getVCH_NOMBRE_EDITORIAL());%>"></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="ideditorial" id="ideditorial" value="<%out.print(editorial.getID_EDITORIAL());%>"></td>
                            <td><button type="submit" class="btn btn-success">ACTUALIZAR</button></td>
                        </tr>
                    </tbody>
                </table>
                <br>
            </form>  
        </div>
    </body>
</html>
