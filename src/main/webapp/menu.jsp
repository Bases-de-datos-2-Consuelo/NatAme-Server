<%-- 
    Document   : prueba
    Created on : 8/10/2021, 10:42:00 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
        
        <link href="${pageContext.request.contextPath}/Menu.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Multinivel.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/estilos.css" rel="stylesheet" type="text/css"/>
        
   
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Natame | Menú</title>
       
      
    </head>

    <body>
        <H3>TIPO: ${tipo}</H3>
        
        <div class="container" id="content" >
            <nav>
                <ul id="menu">
                    <li ><a  href="router?pagina=crear-cliente"><img  src="https://html-online.com/img/01-interactive-connection.png" id="men" >Crear Cliente</a></li>
                    <li >
                        <a href="router?pagina=crear-rep-venta"><img src="https://html-online.com/img/01-interactive-connection.png" id="men" >Crear Representante</a></li>
                    <li ><a href="router?pagina=crear-pedido"><img  src="https://html-online.com/img/03-docs-to-html.png" id="men" />Realizar Pedidos</a></li>
                    <li ><a href=""><img src="https://html-online.com/img/05-gibberish.png" id="men" />Cambio Representante</a></li>
                    <li><a href=""><img  src="https://html-online.com/img/6-table-div-html.png" id="men"  />Estadisticas</a></li>
                    <li>

                        <form action="http://localhost:8083/NatAme-Server/home">

                            <div align="right">
                                <button  class="btn btn-danger btn-circle btn-xl" >Cerrar sesión </button>
                            </div>

                        </form>

                    </li>

                </ul></nav>
        </div>
        <div class="wrapper fadeInDown">
            <br><footer>
                <p><br>
                    <img src="Imagenes\logo.png" id="logo"  alt="User Icon" />
                </p>
                <p> Productos naturales y amigables con el medio ambiente</p>

            </footer>

        </div>


        <!--  <script type='text/javascript' >
       $(document).ready(function(){
          $("#menu a").each(function(){
             var href = $(this).attr("href");
             $(this).attr({ href: "#"});
             $(this).click(function(){
                $("#content").load(href);
             });
          });
       });
       </script> -->

    </body>
</html>
