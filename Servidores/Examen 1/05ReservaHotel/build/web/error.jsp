<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Error</title>
    </head>
    <body>
        <!-- Título de la página -->
        <h1>Error!</h1>

        <!-- Mensaje introductorio -->
        Los errores encontrados son los siguientes:

        <%
            // Recuperamos el atributo "errores" del contexto de la aplicación
            // Este atributo fue creado por el ServletReserva si había datos inválidos
            String errores = (String) getServletContext().getAttribute("errores");

            // Mostramos los errores en la consola del servidor (opcional)
            System.out.println(errores + ".");

            // ⚠️ Importante: con este código, los errores no se muestran en la página al usuario
            // Si quieres que se vean, tendrías que hacer:
            // out.println(errores);
        %>
    </body>
</html>

