<%@page import="modelo.Bd"%>
<%@page import="modelo.Libro"%>
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

        <table border="1px">
            <tr>
                <th>Titulo</th>
                <th>ISBN</th>
                <th>Autor</th>
                <th>Editorial</th>
                <th>Descripción</th>
            </tr>

            <%
                String tit = request.getParameter("tit");
                ArrayList<Libro> listaLibros = Bd.consultarLibros(tit);
                for (int x = 0; x < listaLibros.size(); x++) { %>

                <tr>
                    <td><%=listaLibros.get(x).getTitulo()%></td>
                    <td><%=listaLibros.get(x).getIsbn()%></td>
                    <td><%=listaLibros.get(x).getAutor()%></td>
                    <td><%=listaLibros.get(x).getEditorial()%></td>
                    <td><%=listaLibros.get(x).getDescripcion()%></td>
                </tr>

            <%}%>
        </table>


    </tr>
</body>
</html>
