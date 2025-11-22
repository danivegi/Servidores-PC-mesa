<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
      ServletContext contexto = getServletContext();
      RequestDispatcher rd;
      
      List<Cliente> lista = (List<Cliente>) contexto.getAttribute("lista");
      if (lista == null) {
          lista = new ArrayList<Cliente>();
      }
      
      String filtrado;
      filtrado = (String) request.getParameter("filtrado");
      if (filtrado == null) {
          filtrado = "";
      }
      
      List<Cliente> listaFiltrada;
      if (filtrado.equals("alimentacion")) {
          listaFiltrada = lista.stream()
                            .filter(cl -> cl.getSector().equalsIgnoreCase("alimentacion"))
                            .toList();
      } else if (filtrado.equals("textil")) {
          listaFiltrada = lista.stream()
                            .filter(cl -> cl.getSector().equalsIgnoreCase("textil"))
                            .toList();
      } else if (filtrado.equals("transporte")) {
          listaFiltrada = lista.stream()
                            .filter(cl -> cl.getSector().equalsIgnoreCase("transporte"))
                            .toList();
      } else if (filtrado.equals("medicina")) {
          listaFiltrada = lista.stream()
                            .filter(cl -> cl.getSector().equalsIgnoreCase("medicina"))
                            .toList();
      } else {
          listaFiltrada = lista;
      }
    %>
    
<body>
        <table>
                <th>Empresa</th>
                <th>CIF</th>
                <th>Sector</th>
                <th>Ventas</th>
                
                <% for (Cliente cl : listaFiltrada) { %>
                <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= cl.getNombre() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= cl.getCif() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= cl.getSector() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= cl.getVentas() %></td>
                <tr>
                    <% } %>
                </table>
                
                <table>
                    <tr>
                        <td>
                            <a href="Formulario.jsp">
                                <button>Seguir añadiendo</button>
                            </a>
                        </td>
                        <td>
                            <a href="listado.jsp?filtrado=alimentacion">
                                <button>Ver empresas alimenticias</button>
                            </a>
                        </td>
                        <td>
                            <a href="listado.jsp?filtrado=textil">
                                <button>Ver empresas textil</button>
                            </a>
                        </td>
                        <td>
                            <a href="listado.jsp?filtrado=transporte">
                                <button>Ver empresas transporte</button>
                            </a>
                        </td>
                        <td>
                            <a href="listado.jsp?filtrado=medicina">
                                <button>Ver empresas salud</button>
                            </a>
                        </td>
                    </tr>
                </table>
    </body>
</html>
