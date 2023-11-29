<%-- 
    Document   : menu
    Created on : 09-jul-2023, 19:48:14
    Author     : Gaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid mb-5">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
        <img src="img/BCIISA.JPG" width="30" height="30" class="d-inline-block align-top" alt="Logo BCIISA">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">HOME <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="index.jsp">CERRAR SESION</a>
                </li>
            </ul>

            
            <ul class="navbar-nav">
                <li class="nav-item  pt-2">
                    <p class="badge badge-info">${mensaje}</p>
                    
                </li>
            </ul>

        </div>
    </nav> 
</div>

