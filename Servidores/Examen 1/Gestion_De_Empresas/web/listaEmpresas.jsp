<%-- 
    Document   : listaEmpresas
    Created on : 21 oct 2025, 9:05:19
    Author     : alber
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
      ServletContext contexto = getServletContext();
      List<Cliente> listadoClientes;
      
      if (contexto.getAttribute("lista") != null) {
          listadoClientes = (List<Cliente>) contexto.getAttribute("lista");
      } else {
          listadoClientes = new ArrayList<Cliente>();
      }
      
      String filtrado;
      if (request.getParameter("filtrado") != null) {
          filtrado = request.getParameter("filtrado");
      } else {
          filtrado = "";
      }
      
      List<Cliente> listaFiltrada;
      
      if (filtrado.equals("alimentacion")) {
          listaFiltrada = listadoClientes.stream()
                            .filter(res -> res.getSector().equalsIgnoreCase("alimentacion"))
                            .toList();
      } else if (filtrado.equals("textil")) {
          listaFiltrada = listadoClientes.stream()
                            .filter(res -> res.getSector().equalsIgnoreCase("textil"))
                            .toList();
      } else if (filtrado.equals("transporte")) {
          listaFiltrada = listadoClientes.stream()
                            .filter(res -> res.getSector().equalsIgnoreCase("transporte"))
                            .toList();
      } else if (filtrado.equals("medicina")) {
          listaFiltrada = listadoClientes.stream()
                            .filter(res -> res.getSector().equalsIgnoreCase("medicina"))
                            .toList();
      } else {
          listaFiltrada = listadoClientes;
      }

    %>
    <body>
        <table>
                <th>Empresa</th>
                <th>CIF</th>
                <th>Sector</th>
                <th>Ventas</th>
                
                <% for (Cliente res: listaFiltrada) { %>
                <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getNombreEmpresa() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getCif() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getSector() %></td>
                    <td color="#FFFFFF" bgcolor="#D3A66D"><%= res.getVentas() %></td>
                <tr>
                <% } %>
                </table>
                
                <table>
                    <tr>
                        <td>
                            <a href="listado.jsp">
                                <button>Seguir añadiendo</button>
                            </a>
                        </td>
                        <td>
                            <a href="listaEmpresas.jsp?filtrado=alimentacion">
                                <button>Ver empresas alimenticias</button>
                            </a>
                        </td>
                        <td>
                            <a href="listaEmpresas.jsp?filtrado=textil">
                                <button>Ver empresas textil</button>
                            </a>
                        </td>
                        <td>
                            <a href="listaEmpresas.jsp?filtrado=transporte">
                                <button>Ver empresas transporte</button>
                            </a>
                        </td>
                        <td>
                            <a href="listaEmpresas.jsp?filtrado=medicina">
                                <button>Ver empresas salud</button>
                            </a>
                        </td>
                    </tr>
                </table>
            
    </body>
</html>
