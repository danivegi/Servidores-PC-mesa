<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>

        <style type="text/css">
            body {
                background-color: #FFFFFF;
            }
        </style>
    </head>

    <body>

        <table height="106" border="0" width="972">
            <tr bordercolor="#FF0000" bgcolor="#FF0000">
                <td height="102" bgcolor="#FF0000">&nbsp;&nbsp; <img src="images/logo_telepizza.gif" width="209" height="43" /></td>
            </tr>
        </table>

        <%
            HttpSession sesion = request.getSession();
            ServletContext contexto = getServletContext();
            RequestDispatcher rd;

            if (sesion == null || sesion.getAttribute("usuario") == null) {
                rd = contexto.getRequestDispatcher("/Error.html");
                rd.forward(request, response);
                return;
            }

            String pizzaCarne = request.getParameter("pizzaCarne");
            String cantidadCarne = request.getParameter("cantidadCarne");
            sesion.setAttribute("pizzaCarne", pizzaCarne);
            sesion.setAttribute("cantidadCarne", cantidadCarne);

            String pizzaQuesos = request.getParameter("pizzaQuesos");
            String cantidadQuesos = request.getParameter("cantidadQuesos");
            sesion.setAttribute("pizzaQuesos", pizzaQuesos);
            sesion.setAttribute("cantidadQuesos", cantidadQuesos);

            String pizzaClasicos = request.getParameter("pizzaClasicos");
            String cantidadClasicos = request.getParameter("cantidadClasicos");
            sesion.setAttribute("pizzaClasicos", pizzaClasicos);
            sesion.setAttribute("cantidadClasicos", cantidadClasicos);

            String pizzaInfantil = request.getParameter("pizzaInfantil");
            String cantidadInfantil = request.getParameter("cantidadInfantil");
            sesion.setAttribute("pizzaInfantil", pizzaInfantil);
            sesion.setAttribute("cantidadInfantil", cantidadInfantil);

            String pizzaNatural = request.getParameter("pizzaNatural");
            String cantidadNaturales = request.getParameter("cantidadNaturales");
            sesion.setAttribute("pizzaNatural", pizzaNatural);
            sesion.setAttribute("cantidadNaturales", cantidadNaturales);
        %>

        <table width="972" height="106" border="0">
            <form method="post" action="confirmarTelefono.jsp">
                <tr>
                    <td>
                        <img src="images/domicilio.gif">
                    </td>
                    <td>
                        <img src="images/tienda.gif">
                    </td>
                </tr>
                <tr>
                    <td>
                        Entrega a domicilio
                        <input type="radio" value="domicilio" id="domicilio" name="domicilio">
                    </td>
                    <td>
                        Recoger en tienda
                        <input type="radio" value="tienda" id="tienda" name="tienda">
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <input type="submit" value="Aceptar">
                    </td>

                </tr>
            </form>

        </table>
        <table width="100%" height="106" border="0">
            <tr >
                <td ><img src="images/pie.gif" width="972" height="51" /></td>
            </tr>
        </table>

    </body>
</html>