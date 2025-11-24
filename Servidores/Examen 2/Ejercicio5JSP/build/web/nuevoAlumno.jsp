<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta de alumno</h1>
        
        <form method="post" action="ServletAlumno">
            <label>Nombre</label>
            <input type="text" name="nombre" id="nombre"><br><br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" id="apellidos"><br><br>
            <label>DAWES</label>
            <input type="text" name="dawes" id="dawes"><br><br>
            <label>DAWEC</label>
            <input type="text" name="dawec" id="dawec"><br><br>
            <label>DIW</label>
            <input type="text" name="diw" id="diw"><br><br>
            <label>DAW</label>
            <input type="text" name="daw" id="daw"><br><br>
            <label>FCT</label>
            <input type="text" name="fct" id="fct"><br><br>
            <label>Proyecto</label>
            <input type="text" name="proyecto" id="proyecto"><br><br>
            
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
