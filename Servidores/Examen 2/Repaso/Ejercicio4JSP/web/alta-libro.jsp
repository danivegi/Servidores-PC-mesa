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
        
        <form method="post" action="ServletLibro">
            <label>ISBN</label>
            <input type="text" name="isbn" id="isbn"><br><br>
            
            <label>Titulo</label>
            <input type="text" name="titulo" id="titulo"><br><br>
            
            <label>Autor</label>
            <select name="autor" id="autor">
            <% 
                ArrayList<Autor> listaAutores = Bd.consultarAutores();
                for (int x = 0; x < listaAutores.size(); x++) { %>
            
                <option value="<%=listaAutores.get(x).getIdAutor()%>">
                    <%=listaAutores.get(x).getNombre()%>, <%=listaAutores.get(x).getApellido()%>
                </option>
                <%}%>
            </select><br><br>
            
            <label>Editorial</label>
            <select name="editorial" id="editorial">
            <% 
                ArrayList<Editorial> listaEditoriales = Bd.consultarEditoriales();
                for (int x = 0; x < listaEditoriales.size(); x++) { %>
            
                <option value="<%=listaEditoriales.get(x).getIdEditorial()%>">
                    <%=listaEditoriales.get(x).getNameEditorial()%>
                </option>
                <%}%>
            </select><br><br>
            
            <label>Año de edición</label>
            <input type="text" name="year" id="year"><br><br>
            
            <label>Descripcion</label>
            <input type="text" name="desc" id="desc"><br><br>
            
            <input type="submit" value="Aceptar">
            <input type="reset" value="Cancelar">
                
        </form>
    </body>
</html>
