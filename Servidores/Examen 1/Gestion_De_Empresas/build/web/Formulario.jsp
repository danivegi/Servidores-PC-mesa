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
      List<Cliente> lista = (List<Cliente>) contexto.getAttribute("lista");
      if (lista == null) {
          lista = new ArrayList<Cliente>();
          contexto.setAttribute("lista", lista);
      }
    %>
    <body>
        <form action="ServletCliente" method="POST">
           
        <label>Nombre de la empresa</label><!--  -->
        <input type="text" name="nombreEmpresa"><!--  -->
        
        <label>CIF</label><!--  -->
        <input type="text" name="cif"><br>
        
        <label>Representante Legal de la empresa</label><!--  -->
        <input type="text" name="representante">
        
        <label>NIF</label><!--  -->
        <input type="text" name="nif"><br>
        
        <label>Sector</label><!--  -->
        <input type="radio" name="sector" value="alimentacion"> Alimentacion
        <input type="radio" name="sector" value="textil"> Textil
        <input type="radio" name="sector" value="transporte"> Transporte
        <input type="radio" name="sector" value="medicina"> Medicina <br>
        
        <label>Teléfono</label><!--  -->
        <input type="text" name="telefono"><!--  -->
        
        <label>Email</label><!--  -->
        <input type="email" name="email"><!--  --><br>
        
        <label>Volumen ventas anuales</label><!--  -->
        <input type="text" name="ventas"><!--  --><br>
        
        <label>Observaciones</label><!--  --><br>
        <input type="text" name="observaciones" height="200" width="400"><!--  --><br>
        
        <input type="submit" value="Añadir empresa"><!--  -->
        <input type="reset" value="Borrar empresa">
        </form>
        
        <form action="listado.jsp" method="POST">
            <input type="submit" value="Ver listado">
        </form>
    </body>
</html>
