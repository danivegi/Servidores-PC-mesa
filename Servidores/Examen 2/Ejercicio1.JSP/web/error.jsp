<%-- 
    Document   : error
    Created on : 11 nov 2025, 9:36:52
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
      ServletContext contexto = getServletContext();
      String errores = (String) contexto.getAttribute("errores");
    %>
    <body>
        <h1>Error en la entrada de datos</h1>
        
        <h3>Error en: <%=errores%></h3>
    </body>
</html>
