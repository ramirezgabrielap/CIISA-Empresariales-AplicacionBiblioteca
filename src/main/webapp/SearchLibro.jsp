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
        <jsp:include page='html/menu.jsp'></jsp:include>
        
        <div style="display: grid; justify-content: center; align-items: center;">
            <form action="NewServletSearchLibro" method="POST" onsubmit="return valida()">
                <h1>Búsqueda de Libros</h1>
                <h1>para Editar y/o Eliminar</h1>
                <br>
                <br>
                
                <table class="table table-borderless">
                    <tbody>
                        <tr>
                            <td class="pt-3">
                                <input type="text" name="searchlibro" id="searchlibro">
                            </td>
                            <td><button type="submit" class="btn btn-success"><i class="bi bi-search"></i> BUSCAR</button></td>
                        </tr>
                    </tbody>
                </table>
                
                <br>
            </form>  
            ${respuesta}
        </div>

    </body>
</html>
