<%-- 
    Document   : crear-pedido
    Created on : 8/10/2021, 11:23:24 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="negocio.modelos.Producto" %>
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
            <h2 class="text-primary">Realizar un pedido</h2>
            <form action="http://localhost:8083/NatAme-Server/agregar-pedido">
                <div class="row">
                    <div class="form-group">
                        <label for="">Selecciona los productos</label>
                        <select class="form-control" name="K_PRODUCTO" id="" multiple>

                            <c:forEach var="p" items="${productos}">
                                
                                 <option value="${p.getK_PRODUCTO()}">${p.getN_NOMBRE()} </option>
                            </c:forEach>

                           
                           
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">seleccione el medio de Pago</label>
                            <select class="form-control" name="I_TIPO_PAGO" id="">
                                <option value="PSE">PSE</option>
                                <option value="TARJETA DE CREDITO">TARJETA DE CREDITO</option>
                            </select>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Selecciona estado de pedido</label>
                            <select class="form-control" name="ESTADO_PEDIDO" id="">
                                <option value="GUARDAR">GUARDAR</option>
                                <option value="PAGAR">PAGAR</option>
                            </select>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="calificacion">Calificación</label>
                            <select class="form-control" name="Q_CALIFICACION" id="calificacion">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                    </div>
                </div>

                <h5 class="text-danger">Estos campos son provisionales y posteriormente se quitarán</h5>
                <div class="row">
                    <div class="col">
                        <select name="K_REGION">
                            <option value="1">Caribe</option>
                            <option value="2">Pacífico</option>
                            <option value="3">Andina</option>
                            <option value="4">Llanos orientales</option>
                            <option value="5">Amazonía</option>
                        </select>
                    </div>
                    <div class="col">
                        <input type="text" name="K_PAIS" value="1">
                    </div>


                </div>
                <button type="submit" class="btn btn-outline-success my-3">Enviar</button>
            </form>
        </div>
    </body>
</html>
