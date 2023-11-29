<script>
    function valida() {
        mensaje ="";
        user = document.getElementById("user").value;
        if(user == ""){
            mensaje = mensaje + " * Usuario sin datos \n";
        }
        
        passwd = document.getElementById("passwd").value;
        if(passwd ==""){
            mensaje = mensaje + " * Contraseña sin datos \n";
        }
        
        perfil = document.getElementById("perfil").value;
        if(perfil ==""){
            mensaje = mensaje + " * Perfil sin datos \n";
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="display: grid; justify-content: center; align-items: center">
        <img src="img/BCIISA.JPG" id="miImagen" width="" height="" alt="logoBCIISA">
        <form action="NewServletLogin" method="POST" onsubmit="return valida()">
            <table>
                <tbody>
                    <tr>
                        <td><label for="user">Nombre de Usuario</label></td>
                        <td><input type="email" name="user" id="user" placeholder="jmena@bciica.cl"></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><label for="passwd">Contraseña</label></td>
                        <td><input type="password" name="passwd" id="passwd"></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><label for="perfil">Perfil</label></td>
                        <td><select name="perfil" id="perfil">
                                <option value=""></option>
                                <option>Administrador</option>
                                <option>Administrativo</option>
                            </select></td>
                        <td></td>
                        <td></td>
                    </tr>  
                    <tr>
                        <td></td>
                        <td><button type="submit" class="btn btn-success">INGRESAR</button></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <br>
        </form>
    </body>
</html>

