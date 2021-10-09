<%-- 
    Document   : crear-rep-venta
    Created on : 8/10/2021, 11:15:40 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h2 class="text-primary">Crear un nuevo representante de ventas</h2>
            <form action="http://localhost:8083/NatAme-Server/agregar-representante" method="GET">
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Código de usuario</label>
                            <input class="form-control" name="K_REPRESENTANTE" type="text" value="urep">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Primer nombre</label>
                            <input class="form-control" name="N_NOMBRE1" type="text" value="Juan">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Segundo nombre</label>
                            <input class="form-control" name="N_NOMBRE2" type="text" value="Camilo">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Primer apellido</label>
                            <input class="form-control" name="N_APELLIDO1" type="text" value="Villegas">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Segundo apellido</label>
                            <input class="form-control" name="N_APELLIDO2" type="text" value="Cardona">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Tipo de documento</label>
                            <select class="form-control" name="I_TIPO_DOCUMENTO" id="">
                                <option value="CC">CC</option>
                                <option value="CE">CE</option>
                                <option value="PA">PA</option>
                                <option value="NI">NI</option>
                                <option value="OT">OT</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Número de documento</label>
                        </div><input class="form-control" name="Q_DOCUMENTO" type="text" value="1230">

                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Dirección</label>
                        </div><input class="form-control" name="N_DIRECCION" type="text" value="CALLE 50 #70 08">

                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Correo electrónico</label>
                        </div><input class="form-control" name="N_CORREO" type="email" value="ejemplo1@hotmail.com">

                    </div>
                </div>


                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Genero</label>
                        </div><input class="form-control" name="I_GENERO" type="text" value="M">

                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Fecha de nacimiento</label>
                        </div><input class="form-control" name="F_NACIMIENTO" type="date">

                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Teléfono</label>
                        </div><input class="form-control" name="N_TELEFONO" type="text" value="5707605">

                    </div>
                </div>


                <h3>Información de representante superior</h3>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Código</label>
                        </div><input class="form-control" name="K_REPRESENTANTE_SUPERIOR" type="text" value="rep1">

                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Región</label>
                        </div><input class="form-control" name="K_REGION" type="text" value="1">

                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">País</label>
                        </div><input class="form-control" name="K_PAIS" type="text" value="1">

                    </div>
                </div>

                <button type="submit" class="btn btn-outline-success my-3">Crear representante</button>
            </form>

        </div>
    </body>
</html>
