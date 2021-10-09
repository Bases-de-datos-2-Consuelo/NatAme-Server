<%-- 
    Document   : index
    Created on : 8/10/2021, 11:02:00 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Natame | Login</title>
        <link href="Multinivel.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <link rel="stylesheet" href="./estilos.css">

    </head>

    <body>

        <div class="wrapper fadeInDown">
            <header>
                <h2 class="active"> inicio de sesión </h2>    
            </header>

            <div class="containerLogin">
                <div class="fadeIn first">
                    <p class="heading">
                        <img src="https://image.flaticon.com/icons/png/512/16/16363.png" id="icon"  alt="User Icon" width="70%" height="70%" />  Login in </p>
                </div>
                <div class="box">
                    <p> Usuario</p>
                    <form action="http://localhost:8083/NatAme-Server/login">
                        <div class="form-group">
                            <input id="user" name="user" type="text" class="form-control" placeholder="Ingrese su Usuario">
                        </div>
                </div>
                <div class="box">
                    <p> Password</p>
                    <div class="form-group">

                        <input id="password" name="password" type="text" class="form-control" placeholder="Ingrese su contraseña">
                    </div>
                </div>
                <button class="btnLogin " onclick="ingresar()">Ingresar</button>
                </form>

            </div>
            <br><footer>
                <p><br>
                    <img src="Imagenes\logo.png" id="logo"  alt="User Icon" />
                </p>
                <p> Productos naturales y amigables con el medio ambiente</p>

            </footer>

        </div>


        <script>

            function ingresar() {
                usuario = document.getElementById("usuario").value;
                contrasena = document.getElementById("contrasena").value;

                console.log(usuario + " " + contrasena);


                axios.post('http://localhost:8083/NatAme-Server/login', {user: usuario, password: contrasena}).then((result) => {
                    if (result.data = "Login Correcto") {
                        window.location.href = "http://localhost:8083/NatAme-Server/";
                    } else {
                        console.log("No fue correcto el login")
                    }
                }).catch((err) => {
                    console.log("Hubo error")
                });
            }

        </script>

    </body>
</html>
