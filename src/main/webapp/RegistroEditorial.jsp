
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page='html/head.jsp'></jsp:include>
        <title>JSP Page</title>
        <script>
            
            function valida() {
                mensaje ="";

                nameE = document.getElementById("nameE").value;
                if(nameE == ""){
                    mensaje = mensaje + " * Nombre de la Editorial sin datos \n";
                }

                if(mensaje!=""){
                    mensaje = "Datos faltantes en el formulario  \n \n" + mensaje;
                    alert(mensaje);
                    return false;
                } 
            }
    
  
        </script>
    </head>
    <body>
    <jsp:include page='html/menu.jsp'></jsp:include>

        <div style="display: grid; justify-content: center; align-items: center">
            <h1>Registro de Editoriales</h1>
            <br>
            <form action="NewServletRegistroEditorial" method="POST" onsubmit="return valida()">
                <table>
                    <tbody>
                        <tr>
                            <td><label for="nameE">Nombre de la Editorial</label></td>
                            <td></td>
                            <td></td>
                            <td><input type="text" name="nameE" id="nameE" placeholder="Ercilla"></td>
                        </tr>
                        <tr>
                            <td><br></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><button type="submit" class="btn btn-success">GUARDAR</button></td>
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
