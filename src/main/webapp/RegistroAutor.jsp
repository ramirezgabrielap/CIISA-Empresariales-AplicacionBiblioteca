<script>
    function valida() {
        mensaje ="";
        
        nameA = document.getElementById("nameA").value;
        if(nameA == ""){
            mensaje = mensaje + " * Ingrese el Nombre del Autor para Crearlo \n";
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
    <jsp:include page='html/menu.jsp'></jsp:include>

        <div  style="display: grid; justify-content: center; align-items: center">
            <h1>Registro de Autores</h1>
            <br>
            <form action="NewServletRegistroAutor" method="POST" onsubmit="return valida()">
                <table>
                    <tbody>
                        <tr>
                            <td><label for="nameA">Nombre de Autor</label></td>
                            <td><input type="text" name="nameA" id="nameA" placeholder="Homero"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><button type="submit" class="btn btn-success">CREAR</button></td>
                            <td></td>
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
