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
    <body>
        <h1>Listado de los alumnos de 2 de CFDAW</h1>

        <%
            ArrayList<Alumno> listaAlumnos = new ArrayList<>();
            listaAlumnos = Bd.consultarAlumnos();
        %>

        <table border="1px">
            <tr>
                <th></th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>DAWES</th>
                <th>DAWEC</th>
                <th>DIW</th>
                <th>DAW</th>
                <th>FCT</th>
                <th>Proyecto</th>
                <th>Editar</th>
            </tr>

            <%
                for (int x = 0; x < listaAlumnos.size(); x++) {%>
            <tr>
                <td><input type="checkbox"></td>
                <td><%=listaAlumnos.get(x).getNombre()%></td>
                <td><%=listaAlumnos.get(x).getApellidos()%></td>
                <td><%=listaAlumnos.get(x).getDawes()%></td>
                <td><%=listaAlumnos.get(x).getDawes()%></td>
                <td><%=listaAlumnos.get(x).getDiw()%></td>
                <td><%=listaAlumnos.get(x).getDaw()%></td>
                <td><%=listaAlumnos.get(x).getFct()%></td>
                <td><%=listaAlumnos.get(x).getProyecto()%></td>
                <td><a href="editarAlumnos.jsp?nombre=<%=listaAlumnos.get(x).getNombre()%>">Editar</a></td>
            </tr>
            <%}%>
        </table>
        <br>
        <form method="post" action="nuevoAlumno.jsp">
            <input type="submit" value="Registrar nuevo alumno" >
        </form>
        
    </body>
</html>
