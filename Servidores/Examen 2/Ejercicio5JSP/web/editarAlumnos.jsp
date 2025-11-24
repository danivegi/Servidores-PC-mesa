<%@page import="modelo.Bd"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%
        String nombre = request.getParameter("nombre");
        ArrayList<Alumno> listaAlumnos = Bd.consultarAlumnos();
    %>

    <body>
        <h1>Consulta de alumno</h1>

        <form method="post" action="ServletModAlumno">

            <%
                for (int x = 0; x < listaAlumnos.size(); x++) {
                    if (nombre.equals(listaAlumnos.get(x).getNombre())) {

            %>

            <label>Nombre</label>
            <input type="text" name="nombre" id="nombre" value="<%=listaAlumnos.get(x).getNombre()%>" readonly><br><br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" id="apellidos" value="<%=listaAlumnos.get(x).getApellidos()%>"><br><br>
            <label>DAWES</label>
            <input type="text" name="dawes" id="dawes" value="<%=listaAlumnos.get(x).getDawes()%>"><br><br>
            <label>DAWEC</label>
            <input type="text" name="dawec" id="dawec" value="<%=listaAlumnos.get(x).getDawec()%>"><br><br>
            <label>DIW</label>
            <input type="text" name="diw" id="diw" value="<%=listaAlumnos.get(x).getDiw()%>"><br><br>
            <label>DAW</label>
            <input type="text" name="daw" id="daw" value="<%=listaAlumnos.get(x).getDaw()%>"><br><br>
            <label>FCT</label>
            <input type="text" name="fct" id="fct" value="<%=listaAlumnos.get(x).getFct()%>"><br><br>
            <label>Proyecto</label>
            <input type="text" name="proyecto" id="proyecto" value="<%=listaAlumnos.get(x).getProyecto()%>"><br><br>

            <input type="submit" value="Actualizar datos del alumno">
            <%}
                }%>
        </form>
    </body>
</html>
