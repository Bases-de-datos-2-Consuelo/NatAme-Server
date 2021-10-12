<%-- 
    Document   : cambio-representante
    Created on : 11 oct. 2021, 18:02:58
    Author     : luisy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
        <title>Cambio de representante</title>
    </head>
    <body>
        <form action="cambioRepresentante">
            <div class="form-group">
                            <label for="">Cambio de representante</label>
                            
                            <select class="form-control" name="K_REPRESENTANTE" id="">
                                <c:forEach var="r" items="${representantes}">
                                    <option value="${r.getK_REPRESENTANTE()}">${r.getK_REPRESENTANTE()} - ${r.getN_NOMBRE1()} </option>
                                </c:forEach>
                                
                            </select>
            </div>
            
            <button type="submit" class="btn btn-outline-success my-3">Cambiar</button>
        </form>
                                
      <div class="alert alert-success" role="alert">
                ${mensaje}
            </div>                          
    </body>
</html>
