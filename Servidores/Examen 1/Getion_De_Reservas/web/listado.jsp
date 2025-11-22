<%@page import="java.util.Collections"%>
<%@page import="modelo.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        
        if (filtrado.equals("Pension Completa")) {
            listaFiltrada = listadoReservas.stream()
                            .filter(res -> res.getAlojamiento().equalsIgnoreCase("Pension Completa"))
                            .toList();
        } else if (filtrado.equals("Media Pension")) {
            listaFiltrada = listadoReservas.stream()
                            .filter(res -> res.getAlojamiento().equalsIgnoreCase("Media Pension"))
                            .toList();
        } else if (filtrado.equals("Sin Servicios")) {
            listaFiltrada = listadoReservas.stream()
                            .filter(res -> res.getExtras().equalsIgnoreCase("Sin Servicios"))
                            .toList();
        } else {
            listaFiltrada = listadoReservas;
        }
        
    %>
        
        <body>
    <div><img src="Logo1.png" alt="" width="200" height="200">
          <table width="842">
                <th>Nombre</th>
                <th>Fecha de Entrada</th>
                <th>Fecha de Salidad</th>
                <th>Regimen de alojamiento</th>
                <th>Servisios contratados</th>
                <th>Provincia</th>
                
                <% for (Reserva res: listaFiltrada) { %>
                <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getNombre() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getFechaEntrada() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getFechaSalida() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getAlojamiento() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getExtras() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getProvincia() %></td>
                <tr>
                <% } %>
                

                           
             
            </table>
        <table width="842" border="0">
          <tr>
                <!-- Vuelve al formulario principal -->
                <td>
                    <a href="index.jsp">
                        <button>Seguir añadiendo reservas</button>
                    </a>
                </td>

                <!-- Filtra las reservas por tipo de pensión o por servicios -->
                <td>
                    <a href="listado.jsp?filtrado=Pension Completa">
                        <button>Ver reservas de Pensión completa</button>
                    </a>
                </td>

                <td>
                    <a href="listado.jsp?filtrado=Media Pension">
                        <button>Ver reservas de Media pensión</button>
                    </a>
                </td>

                <td>
                    <a href="listado.jsp?filtrado=Sin Servicios">
                        <button>Ver reservas sin servicios extras</button>
                    </a>
                </td>
            </tr>
        </table>
       
    </div>

        
    </body>
</html>