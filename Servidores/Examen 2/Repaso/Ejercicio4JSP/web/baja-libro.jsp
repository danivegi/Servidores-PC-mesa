<%@page import="modelo.Titulo"%>
<%@page import="modelo.Editorial"%>
<%@page import="modelo.Bd"%>
<%@page import="modelo.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestión de Librería</h1>
        
        <a href="alta-libro.jsp">Alta de libro</a><br><br>
        <a href="modifica-libro.jsp">Modificación de libro</a><br><br>
        <a href="baja-libro.jsp">Baja de libro</a><br><br>
        <a href="listado-libros.jsp">Listado de libro</a><br><br>
        
        <form method="post" action="ServletBorrar">
            
            <label>Titulo del libro</label>
            <select name="titulo" id="titulo">
            <% 
                ArrayList<Titulo> listaTitulos = Bd.consultarTitulos();
                for (int x = 0; x < listaTitulos.size(); x++) { %>
            
                <option value="<%=listaTitulos.get(x).getTitulo()%>">
                    <%=listaTitulos.get(x).getTitulo()%>
                </option>
                <%}%>
            </select><br><br>
            
            <input type="submit" value="Borrar">
                
        </form>
    </body>
</html>
