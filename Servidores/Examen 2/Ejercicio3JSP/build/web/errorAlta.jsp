<%-- 
    Document   : errorAlta
    Created on : 21 nov 2025, 15:48:06
    Author     : Dani_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Error!</h2>
        
        <%
          String errores = (String) getServletContext().getAttribute("errores");
          out.println(errores + ",");
        %>
    </body>
</html>
