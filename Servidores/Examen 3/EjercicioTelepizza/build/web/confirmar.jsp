<%@page import="modelo.Bd"%>
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
            ServletContext contexto = getServletContext();
            RequestDispatcher rd;
            String fecha = (String) contexto.getAttribute("fechaPedido");

            HttpSession sesion = request.getSession();
            
            if (sesion == null || sesion.getAttribute("usuario") == null) {
                rd = contexto.getRequestDispatcher("/Error.html");
                rd.forward(request, response);
                return;
            }
            
            double precioCarne = 0;
            double precioQuesos = 0;
            double precioClasicos = 0;
            double precioInfantil = 0;
            double precioNatural = 0;

        %>
        <table width="972" height="106" border="0" align="center">
            <p><b>Gracias</b></p>
            <p>Pepa, tu pedido ha sido tramitado a las <%=fecha%>, y consta de los siguientes productos:</p>

            <table border="1px">
                <tr>
                    <th>Cantidad</th>
                    <th>Descripción</th>
                    <th>Precio Unidad</th>
                </tr>

                <%
                    int cantCarne = Integer.parseInt(sesion.getAttribute("cantidadCarne").toString());
                    if (cantCarne > 0) {
                %>
                <tr>
                    <td>
                        <%=cantCarne%>
                    </td>
                    <td>
                        <%=sesion.getAttribute("pizzaCarne")%>
                    </td>
                    <td>
                        <% String pizzaCarne = (String) sesion.getAttribute("pizzaCarne");
                            precioCarne = Bd.consultarPrecio(pizzaCarne);
                            out.println(precioCarne);
                        %>
                    </td>
                </tr>
                <%}%>

                <%
                    int cantQuesos = Integer.parseInt(sesion.getAttribute("cantidadQuesos").toString());
                    if (cantQuesos > 0) {
                %>
                <tr>
                    <td>
                        <%=cantQuesos%>
                    </td>
                    <td>
                        <%=sesion.getAttribute("pizzaQuesos")%>
                    </td>
                    <td>
                        <% String pizzaQuesos = (String) sesion.getAttribute("pizzaQuesos");
                            precioQuesos = Bd.consultarPrecio(pizzaQuesos);
                            out.println(precioQuesos);
                        %>
                    </td>
                </tr>
                <%}%>

                <%
                    int cantidadClasicos = Integer.parseInt(sesion.getAttribute("cantidadClasicos").toString());
                    if (cantidadClasicos > 0) {
                %>
                <tr>
                    <td>
                        <%=cantidadClasicos%>
                    </td>
                    <td>
                        <%=sesion.getAttribute("pizzaClasicos")%>
                    </td>
                    <td>
                        <% String pizzaClasicos = (String) sesion.getAttribute("pizzaClasicos");
                            precioClasicos = Bd.consultarPrecio(pizzaClasicos);
                            out.println(precioClasicos);
                        %>
                    </td>
                </tr>
                <%}%>

                <%
                    int cantInfantil = Integer.parseInt(sesion.getAttribute("cantidadInfantil").toString());
                    if (cantInfantil > 0) {
                %>
                <tr>
                    <td>
                        <%=cantInfantil%>
                    </td>
                    <td>
                        <%=sesion.getAttribute("pizzaInfantil")%>
                    </td>
                    <td>
                        <% String pizzaInfantil = (String) sesion.getAttribute("pizzaInfantil");
                            precioInfantil = Bd.consultarPrecio(pizzaInfantil);
                            out.println(precioInfantil);
                        %>
                    </td>
                </tr>
                <%}%>

                <%
                    int cantNaturales = Integer.parseInt(sesion.getAttribute("cantidadNaturales").toString());
                    if (cantNaturales > 0) {
                %>
                <tr>
                    <td>
                        <%=cantNaturales%>
                    </td>
                    <td>
                        <%=sesion.getAttribute("pizzaNatural")%>
                    </td>
                    <td>
                        <% String pizzaNatural = (String) sesion.getAttribute("pizzaNatural");
                            precioNatural = Bd.consultarPrecio(pizzaNatural);
                            out.println(precioNatural);
                        %>
                    </td>
                </tr>
                <%}%>
                <tr>
                    <td></td>
                    <td>
                        <%
                            double total = (cantCarne * precioCarne) + (cantQuesos * precioQuesos) + (cantidadClasicos * precioClasicos) + (cantInfantil * precioInfantil) + (cantNaturales * precioNatural);
                            out.println ("<p><b>TOTAL PEDIDO: " + total + " euros</b></p>");
                        %>
                    </td>
                </tr>
            </table>
        </table>
        <table width="100%" height="106" border="0">
            <tr >
                <td ><img src="images/pie.gif" width="972" height="51" /></td>
            </tr>
        </table>

    </body>
</html>