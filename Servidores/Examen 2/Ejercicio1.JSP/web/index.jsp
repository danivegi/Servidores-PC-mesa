<%-- 
    Document   : index
    Created on : 11 nov 2025, 9:08:45
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Introduce los datos de entrada</h1>
        <form action="ServletCambio" method="POST">
            <label>Importe de venta:</label>
            <input type="text" name="importe">
            <br><br>
            <label>Cantidad entregada:</label>
            <input type="text" name="entregado">
            <br><br>
            <input type="submit" value="Enviar">
            <input type="reset" value="Borrar">
        </form>
    </body>
</html>
