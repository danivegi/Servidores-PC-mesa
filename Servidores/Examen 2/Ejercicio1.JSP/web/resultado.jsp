<%-- 
    Document   : resultado
    Created on : 11 nov 2025, 9:37:00
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos de entrada</h1>

        <%
            ServletContext contexto = getServletContext();
            String importe = request.getParameter("importe").replace(",", ".");
            String entregado = request.getParameter("entregado").replace(",", ".");
            
            double importeDouble = Double.parseDouble(importe);
            double entregadoDouble = Double.parseDouble(entregado);

            double cambioDouble = entregadoDouble - importeDouble;
            int cont100 = 0;
            int cont50 = 0;
            int cont20 = 0;
            int cont10 = 0;
            int cont5 = 0;
            int cont2 = 0;
            int cont1 = 0;
            int cont50cent = 0;
            int cont20cent = 0;
            int cont10cent = 0;
            int cont5cent = 0;
            int cont2cent = 0;
            int cont1cent = 0;
            boolean error = false;

            if (cambioDouble < 0) {
                error = true;
            } else {
                int cambio = (int) Math.round(cambioDouble * 100);
                do {
                    if (cambio >= 10000) {
                        cont100++;
                        cambio = cambio - 10000;
                    } else if (cambio >= 5000) {
                        cont50++;
                        cambio = cambio - 5000;
                    } else if (cambio >= 2000) {
                        cont20++;
                        cambio = cambio - 2000;
                    } else if (cambio >= 1000) {
                        cont10++;
                        cambio = cambio - 1000;
                    } else if (cambio >= 500) {
                        cont5++;
                        cambio = cambio - 500;
                    } else if (cambio >= 200) {
                        cont2++;
                        cambio = cambio - 200;
                    } else if (cambio >= 100) {
                        cont1++;
                        cambio = cambio - 100;
                    } else if (cambio >= 50) {
                        cont50cent++;
                        cambio = cambio - 50;
                    } else if (cambio >= 20) {
                        cont20cent++;
                        cambio = cambio - 20;
                    } else if (cambio >= 10) {
                        cont10cent++;
                        cambio = cambio - 10;
                    } else if (cambio >= 5) {
                        cont5cent++;
                        cambio = cambio - 5;
                    } else if (cambio >= 2) {
                        cont2cent++;
                        cambio = cambio - 2;
                    } else if (cambio >= 1) {
                        cont1cent++;
                        cambio = cambio - 1;
                    }
                } while (cambio > 0);
            }
        %>

        <p>Importe venta: <%=importeDouble%>€</p>

        <p>Cantidad entregada: <%=entregadoDouble%>€</p>


        <h1>Datos de salida</h1><!-- comment -->
        <% if (error) {%><p>La cantidad entregada debe ser mayor</p><% } %>
        <% if (cont100 > 0) {%><p><%= cont100%> billete(s) de 100€</p><% } %>
        <% if (cont50 > 0) {%><p><%= cont50%> billete(s) de 50€</p><% } %>
        <% if (cont20 > 0) {%><p><%= cont20%> billete(s) de 20€</p><% } %>
        <% if (cont10 > 0) {%><p><%= cont10%> billete(s) de 10€</p><% } %>
        <% if (cont5 > 0) {%><p><%= cont5%> billete(s) de 5€</p><% } %>
        <% if (cont2 > 0) {%><p><%= cont2%> moneda(s) de 2€</p><% } %>
        <% if (cont1 > 0) {%><p><%= cont1%> moneda(s) de 1€</p><% }%>
        <% if (cont50cent > 0) {%><p><%= cont50cent%> moneda(s) de 50 céntimos</p><% }%>
        <% if (cont20cent > 0) {%><p><%= cont20cent%> moneda(s) de 20 céntimos</p><% }%>
        <% if (cont10cent > 0) {%><p><%= cont10cent%> moneda(s) de 10 céntimos</p><% }%>
        <% if (cont5cent > 0) {%><p><%= cont5cent%> moneda(s) de 5 céntimos</p><% }%>
        <% if (cont2cent > 0) {%><p><%= cont2cent%> moneda(s) de 2 céntimos</p><% }%>
        <% if (cont1cent > 0) {%><p><%= cont1cent%> moneda(s) de 1 céntimos</p><% }%>
    </body>
</html>
