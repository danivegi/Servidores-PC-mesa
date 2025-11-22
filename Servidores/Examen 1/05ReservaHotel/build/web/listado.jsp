<%-- 
    Página: listado.jsp
    Función: Muestra todas las reservas almacenadas en el contexto, permitiendo filtrarlas
              por tipo de pensión o por servicios extra.
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Reserva"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>

        <%
            // Obtenemos el contexto de la aplicación (donde está guardada la lista de reservas)
            ServletContext contexto = request.getServletContext();

            // Recuperamos la lista de reservas del contexto si existe; si no, creamos una vacía
            List<Reserva> listadoReservas = 
                        ((List<Reserva>)contexto.getAttribute("lista") != null)
                        ? (List<Reserva>)contexto.getAttribute("lista")
                        : new ArrayList<Reserva>();

            // Ordenamos las reservas por la fecha de entrada (usando compareTo de la clase Reserva)
            Collections.sort(listadoReservas);

            // Obtenemos el parámetro "filtrado" desde la URL (si el usuario ha pulsado algún botón de filtrado)
            String filtrado = (request.getParameter("filtrado") != null) 
                              ? request.getParameter("filtrado") 
                              : "";

            // Lista que almacenará las reservas filtradas según el criterio seleccionado
            List<Reserva> listaFiltrada;

            // Filtrado por tipo de pensión o servicios extra usando Java Streams:
            if (filtrado.equals("pensionCompleta")) {
                // Filtra solo las reservas cuyo tipo de pensión es "completa"
                listaFiltrada = listadoReservas.stream()
                               .filter(res -> res.getTipoPension().equalsIgnoreCase("completa"))
                               .toList();

            } else if (filtrado.equals("mediaPension")) {
                // Filtra las reservas con "media pensión"
                listaFiltrada = listadoReservas.stream()
                               .filter(res -> res.getTipoPension().equalsIgnoreCase("media"))
                               .toList();

            } else if (filtrado.equals("sinServicios")) {
                // Filtra las reservas que no tienen servicios extras contratados
                listaFiltrada = listadoReservas.stream()
                               .filter(res -> res.getServiciosExtras().length() == 0)
                               .toList();

            } else {
                // Si no hay ningún filtro, se muestran todas las reservas
                listaFiltrada = listadoReservas;
            }
        %>

        <!-- Estilos básicos para la tabla -->
        <style>
            tr {
                color: #FFFFFF;
            }
            td, th {
                background-color: #D3A66D;
                margin: 2px;
            }
        </style>
    </head>

<body>
    <div>
        <!-- Logo del hotel -->
        <img src="Logo1.png" alt="" width="200" height="200">

        <!-- Tabla principal donde se muestran las reservas -->
        <table width="842">
            <th>Nombre</th>
            <th>Fecha de Entrada</th>
            <th>Fecha de Salida</th>
            <th>Régimen de alojamiento</th>
            <th>Servicios contratados</th>
            <th>Provincia</th>

            <!-- Bucle que recorre la lista de reservas filtradas y muestra una fila por cada una -->
            <% for (Reserva res : listaFiltrada) { %>
                <tr>
                    <td><%= res.getNombre() %></td>
                    <td><%= res.getFechaEntrada() %></td>
                    <td><%= res.getFechaSalida() %></td>
                    <td><%= res.getTipoPension() %></td>
                    <td><%= res.getServiciosExtras() %></td>
                    <td><%= res.getProvincia() %></td>
                </tr>
            <% } %>
        </table>

        <!-- Botones de navegación y filtrado -->
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
                    <a href="listado.jsp?filtrado=pensionCompleta">
                        <button>Ver reservas de Pensión completa</button>
                    </a>
                </td>

                <td>
                    <a href="listado.jsp?filtrado=mediaPension">
                        <button>Ver reservas de Media pensión</button>
                    </a>
                </td>

                <td>
                    <a href="listado.jsp?filtrado=sinServicios">
                        <button>Ver reservas sin servicios extras</button>
                    </a>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
