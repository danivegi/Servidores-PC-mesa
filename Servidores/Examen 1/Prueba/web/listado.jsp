<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Reserva"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <%
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        List<Reserva> lista = (List<Reserva>) contexto.getAttribute("lista");
        if (lista == null) {
            lista = new ArrayList<Reserva>();
        } else {
            lista = (List<Reserva>) contexto.getAttribute("lista");
        }
        
        Collections.sort(lista);
        
        String filtrado;
        filtrado = request.getParameter("filtrado");
        if (filtrado == null) {
            filtrado = "";
        }
        
        List<Reserva> listaFiltrada;
        if (filtrado.equals("pension completa")) {
            listaFiltrada = lista.stream()
                            .filter(res -> res.getAlojamiento().equalsIgnoreCase("pension completa"))
                            .toList();
        } else if(filtrado.equals("media pension")) {
            listaFiltrada = lista.stream()
                            .filter(res -> res.getAlojamiento().equalsIgnoreCase("media pension"))
                            .toList();
        } else if (filtrado.equals("sin servicios")) {
            listaFiltrada = lista.stream()
                            .filter(res -> res.getExtras().equalsIgnoreCase("sin servicios"))
                            .toList();
        } else {
            listaFiltrada = lista;
        }
    %>

    <body>
        <div><img src="logo.png" alt="" width="200" height="200">
            <table width="842">
                <th>Nombre</th>
                <th>Fecha de Entrada</th>
                <th>Fecha de Salidad</th>
                <th>Regimen de alojamiento</th>
                <th>Servisios contratados</th>
                <th>Provincia</th>

                <% for (Reserva res : listaFiltrada) { %>
                <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%=res.getNombre()%></td>
                    <td bgcolor="#D3A66D"><%=res.getFechaEntrada()%></td>
                    <td bgcolor="#D3A66D"><%=res.getFechaSalida()%></td>
                    <td bgcolor="#D3A66D"><%=res.getAlojamiento()%></td>
                    <td bgcolor="#D3A66D"><%=res.getExtras()%></td>
                    <td bgcolor="#D3A66D"><%=res.getProvincia()%></td>
                </tr>  
                <% } %>
                <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#D3A66D">&nbsp; </td>
                    <td bgcolor="#D3A66D">&nbsp; </td>
                    <td bgcolor="#D3A66D">&nbsp; </td>
                    <td bgcolor="#D3A66D">&nbsp; </td>
                    <td bgcolor="#D3A66D">&nbsp; </td>
                    <td bgcolor="#D3A66D">&nbsp; </td>

            </table>
            <table width="842" border="0">
                <tr>
                    <td>
                        <a href="index.jsp">
                            <button>Seguir añadiendo reservas</button>
                        </a>
                    </td>
                    <td>
                        <a href="listado.jsp?filtrado=pension completa">
                            <button>Ver reservas de Pension completa</button>
                        </a>
                    </td>
                    <td>
                        <a href="listado.jsp?filtrado=media pension">
                            <button>Ver reservas de media pension</button>
                        </a>
                    </td>
                    <td>
                        <a href="listado.jsp?filtrado=sin servicios">
                            <button>Ver reservas sin servicios extras</button>
                        </a>
                    </td>
                   
                </tr>
            </table>

        </div>
    </body>

</html>
