<%-- 
    Document   : generarFactura
    Created on : 10 oct. 2021, 20:00:15
    Author     : luisy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Imprimir Factura</title>
    </head>
    <body>
        
        ${k_pedido}
        
       
        <form action="ImprimirFactura">
            <div class="form-group">
                            <label for="">Código de la factura</label>
                            <input class="form-control" name="K_PEDIDO" type="text" value="">
            </div>
            
            <button type="submit" class="btn btn-outline-success my-3">Imprimir Factura</button>
        </form>
        
        <div class="container p5">
        
        <h1 class="text-center text-danger">Factura de compra NATAME</h1>
        
        <h3 class="text-center text-secondary">${encabezado[0]}</h3>
        <h3 class="text-center text-secondary">${encabezado[1]}</h3>
        <h3 class="text-center text-secondary">${encabezado[2]}</h3>
        
    <c:forEach var="d" items="${detalles}">
        <h4 class="text-center text-primary">${d}</h4>
        
    </c:forEach>
    <h5 class="text-center text-success">${encabezado[3]} </h5>
    <h5 class="text-center text-success">${encabezado[4]} </h5>
    
         </div>
         
    
    <hr>
    
    <form action="PromedioRepresentante">
            <div class="form-group">
                            <label for="">Promedio de un representante</label>
                            <input class="form-control" name="K_REPRESENTANTE_VENTAS" type="text" value="">
            </div>
            
            <button type="submit" class="btn btn-outline-success my-3">Obtener promedio</button>
     </form>
    
    ${promedio}
    
    </body>
</html>
