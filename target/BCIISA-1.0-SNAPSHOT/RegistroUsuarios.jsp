<script>
    function valida() {
        mensaje ="";
        rut = document.getElementById("rut").value;
        if(rut ==""){
            mensaje = mensaje + " * Rut sin datos \n";
        }
        name = document.getElementById("name").value;
        if(name == ""){
            mensaje = mensaje + " * Nombre sin datos \n";
        } 
        if(mensaje!=""){
            mensaje = "Datos faltantes en el formulario  \n \n" + mensaje;
            alert(mensaje);
            return false;
        }   
    }
    
  
</script>
<script>
    function validaRut(){
        var arut = new Array(8);
        var i, j, dv;
        if ((document.getElementById("rut").value.length) = 0 ){
            alert("Debe ingresar un Número valido");
        } else {
            for (i = 1; i < 9 ; i++){
                arut[i]=0;
            }
            i = 0;
            for(j = (9 -(document.getElementById("rut").value.length)); j<9; j++){
                if((document.getElementById("rut").value.substr(i, 1) >= 0) & (document.getElementById("rut").value.substr(i, 1) <=9)) {
                    arut[j] = document.getElementById("rut").value.substr(i, 1);
                    i++;
                } else {
                    alert("Debe ingresar solo numeros!");
                    i=0;
                    break;
                }
            }
            if (i>0){
                dv = 11 - (( (arut[1]*3) + (arut[2]*2) + (arut[3]*7) + (arut[4]*6) + (arut[5]*5) + (arut[6]*4) + (arut[7]*3) + (arut[8]*2) )%11)
                if (dv === 10){
                    dv = "K";
                } else if (dv === 11){
                    dv = "0";
                }
                document.getElementById("rutDV").value= dv;
                return dv;
            }
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
    <body style="background-color: azure">
    <jsp:include page='html/menu.jsp'></jsp:include>

        <div style="display: grid; justify-content: center; align-items: center">
            <h1>Registro de Usuarios</h1>
            <br>
            <form action="NewServletRegistroUsuario" method="POST" onsubmit="return valida()">
                <table>
                    <tbody>
                        <tr>
                            <td><label for="rut">Rut</label></td>
                            <td><input type="text" name="rut" id="rut" placeholder="17309211" onkeyup="validaRut()"></td>
                            <td><label for="rutDV">DV</label></td>
                            <td><input type="text" name="rutDV" id="rutDV" placeholder="K" disabled="true"></td>
                        </tr>
                        <tr>
                            <td><label for="name">Nombre</label></td>
                            <td><input type="text" name="name" id="name" placeholder="Juanito"></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <button class="btn btn-success" type="submit">CREAR</button>

            </form>     
        </div>
    </body>
</html>
