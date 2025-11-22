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
        List<Reserva> listadoReservas;
        
        if (contexto.getAttribute("lista") != null) {
            listadoReservas = (List<Reserva>) contexto.getAttribute("lista");
        } else {
            listadoReservas = new ArrayList<Reserva>();
        }
        
        Collections.sort(listadoReservas);
        
        String filtrado;
        if (request.getParameter("filtrado") != null) {
            filtrado = request.getParameter("filtrado");
        } else {
            filtrado = "";
        }
        
        List<Reserva> listaFiltrada;
        
        if (filtrado.equals("pension completa")) {
            listaFiltrada = listadoReservas.stream()
                            .filter(res -> res.getAlojamiento().equalsIgnoreCase("pension completa"))
                            .toList();
        } else if (filtrado.equals("media pension")) {
            listaFiltrada = listadoReservas.stream()
                            .filter(res -> res.getAlojamiento().equalsIgnoreCase("media pension"))
                            .toList();
        } else if (filtrado.equals("sin servicios")) {
            listaFiltrada = listadoReservas.stream()
                            .filter(res -> res.getExtras().equals("sin servicios"))
                            .toList();
        } else {
            listaFiltrada = listadoReservas;
        }
        
    %>
    <body>
        <div><img src="Logo1.png" width="200" height="200">
            <table width="842">
                <th>Nombre</th>
                <th>Fecha de Entrada</th>
                <th>Fecha de Salidad</th>
                <th>Regimen de alojamiento</th>
                <th>Servicios contratados</th>
                <th>Provincia</th>

                <% for (Reserva res : listaFiltrada) { %>
                    <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getNombre() %> </td>
                    <td bgcolor="#D3A66D"><%= res.getFechaEntrada()%></td>
                    <td bgcolor="#D3A66D"><%= res.getFechaSalida()%> </td>
                    <td bgcolor="#D3A66D"><%= res.getAlojamiento()%></td>
                    <td bgcolor="#D3A66D"><%= res.getExtras()%></td>
                    <td bgcolor="#D3A66D"><%= res.getProvincia()%> </td>
                </tr>  
                <% } %>
                

            </table>
            <table width="842" border="0">
                <tr>
                    <td>
                        <a <link href="index.jsp">
                            <button>Seguir añadiendo reservas</button>
                        </a>
                    </td>
                     <td>
                        <a <link href="listado.jsp?filtrado=pension completa">
                            <button>Ver reservas de Pension completa</button>
                        </a>
                    </td>
                     <td>
                        <a <link href="listado.jsp?filtrado=media pesnion">
                            <button>Ver reservas de media pension</button>
                        </a>
                    </td>
                     <td>
                        <a <link href="listado.jsp?filtrado=sin servicios">
                            <button>Ver reservas sin servicios extras</button>
                        </a>
                    </td>
                </tr>
            </table>


        </div>
    </body>

</html>
