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

    <tr align="center">
    <form method="post" action="rtdo-listado-libros.jsp">
        <label>Titulo del libro</label>
        <input type="text" name="tit" id="tit">
        <input type="submit" value="Buscar">
    </form>
</tr>
</body>
</html>
