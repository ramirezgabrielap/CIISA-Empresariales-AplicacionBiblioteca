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
        phone_number = document.getElementById("phone_number").value;
        if(phone_number ==""){
            mensaje = mensaje + " * Número telefónico sin datos \n";
        }
        mail = document.getElementById("mail").value;
        if(mail ==""){
            mensaje = mensaje + " * Email sin datos \n";
        }
        nac = document.getElementById("nac").value;
        if(nac ==""){
            mensaje = mensaje + " * Fecha de Nacimiento sin datos \n";
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
<script>
    function soloNumeros(e){
        var key = window.Event ? e.which : e.keyCode
        return (key >= 48 && key <= 57)
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
            <h1>Registro de Cliente</h1>
            <br>
            <form action="NewServletRegistroCliente" method="POST" onsubmit="return valida()">
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
                            <td><input type="text" name="name" id="name" placeholder="Juanito Pérez Pereira"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="phone_number">Teléfono de contacto</label></td>
                            <td><input type="text" name="phone_number" id="phone_number" placeholder="56979999999" onkeypress="return soloNumeros(event)"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="mail">Correo Electrónico</label></td>
                            <td><input type="email" name="mail" id="mail" placeholder="gaba@gmail.com"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label for="nac">Fecha de nacimiento</label></td>
                            <td><input type="date" name="nac" id="nac"></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td><br></td>
                            <td></td>
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
