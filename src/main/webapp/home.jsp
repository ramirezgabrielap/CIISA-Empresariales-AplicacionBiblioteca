<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page='html/head.jsp'></jsp:include>
        <title>Home</title>
    </head>
    

    
    <body style="background-color:#F8F9F9">
        
    <jsp:include page='html/menu.jsp'></jsp:include>

        <div class="container">
            <div class="row mb-5">
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="RegistroCliente.jsp">
                            <p class="card-text"><i class="bi bi-person-add"></i> REGITRO DE CLIENTES</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="CatalogoLibros.jsp">
                            <p class="card-text"><i class="bi bi-book"></i> CATALOGO DE LIBROS</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="RegistroUsuarios.jsp">
                            <p class="card-text"><i class="bi bi-person-vcard"></i> REGISTRO DE USUARIOS</p>
                            </a>
                        </div>
                    </div>
                </div>  
            </div>
        </div>
                  
        <div class="container">
            <div class="row mb-5">  
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="RegistroLibros.jsp">
                            <p class="card-text"><i class="bi bi-journal-plus"></i> INGRESO DE LIBROS</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="RegistroEditorial.jsp">
                            <p class="card-text"><i class="bi bi-house-add"></i> INGRESO DE EDITORIALES</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="RegistroAutor.jsp">
                            <p class="card-text"><i class="bi bi-pen"></i> INGRESO DE AUTORES</p>
                            </a>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
        <div class="container">
            <div class="row mb-5">  
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="SearchLibro.jsp">
                            <p class="card-text"><i class="bi bi-journal-x"></i> EDITAR - ELIMINAR LIBROS</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="SearchEditorial.jsp">
                            <p class="card-text"><i class="bi bi-house-dash"></i> EDITAR - ELIMINAR EDITORIALES</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow">
                        <div class="card-body">
                            <a href="SearchAutor.jsp">
                            <p class="card-text"><i class="bi bi-pencil"></i> EDITAR - ELIMINAR AUTORES</p>
                            </a>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
        <div class="container">
            <div class="row mb-5">         
                <div class="col">
                    <div class="card shadow">
                        <div align="center" class="card-body">
                            <p class="card-text"><i class="bi bi-gear"></i> CONFIGURACION</p>
                        </div>
                    </div>
                    <br>
                </div> 
                <br>
            </div>
            <br>
        </div>
        
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

    </body>
    <footer style="display: grid; justify-content: center; align-items: center">
        <div>
            <br>
            <p class="copyright">© 2023 Copyright - Desarrollado por Gabriela Ramírez
            <a alt="GitHub" href="https://github.com/ramirezgabrielap" target="_blank">
                <img height="18" src="https://cdn-icons-png.flaticon.com/512/25/25231.png" alt="GitHub">
            </a>
            <a alt="LinkedIn" href="https://www.linkedin.com/in/gabriela-ramirez-perez-grp/" target="_blank">
                <img height="18" src="https://www.aluracursos.com/assets/img/challenges/oracle-one/logo-linkedin.1657102612.svg" alt="LinkedIn">
            </a>
        </div>
    </footer>
</html>
