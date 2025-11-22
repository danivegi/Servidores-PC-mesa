<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin título</title>
</head>

    
<body>

<table width="100%" border="0">
  <tr>
    <td colspan="7" bgcolor="#333333">&nbsp;</td>
  </tr>
  <tr align="center">
    <td colspan="7" bgcolor="#CCCCCC"><h1>APLICACIÓN DE GESTIÓN COMERCIAL</h1></td>
  </tr>
  
  <tr align="center">
    <td>
        <a link href="ventas.jsp">
        <img src="imagenes/ventas.jpg" width="180" height="123" />
        </a>
    </td>
    <td>
        <a link href="productos.jsp">
        <img src="imagenes/productos.jpg" width="180" height="123" />
        </a>
    </td>
    <td>
        <a link href="comerciales.jsp">
        <img src="imagenes/comerciales.jpg" alt="" width="180" height="123" />
        </a>
    </td>
      
    <tr align="center">
        <td>
            <a href="listado-ventas.jsp">
            <img src="imagenes/listado-ventas.jpg" width="180" height="80"/>
            </a>
        </td>
    </tr>
      
    <tr align="center">
        <td>
            <a href="nuevaVenta.jsp">
            <img src="imagenes/nueva-venta.jpg" width="180" height="80"/>
            </a>
        </td>
    </tr>
  <tr>
    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7">
        <table width="50%" border="0" align="center">
            <form id="form1" name="form1" method="post" action="rtdo-listado-ventas.jsp">
                <tr align="center">
                    <td colspan="2"><h3>Listado de ventas</h3></td>
                </tr>
                <tr>
                    <td width="50%" align="right">Producto</td>
                    <td width="50%">
                        <select id="sel" name="sel">
                            <%
                                ArrayList<Producto> listaProductos = modelo.Bd.consultarProductos();
                                for (int i = 0; i < listaProductos.size(); i++) { %>
                                    <option value ="<%=listaProductos.get(i).getRef().toString()%>">
                                        <%=listaProductos.get(i).getNombre().toString() %> - <%=listaProductos.get(i).getDescripcion() %>
                                    </option>
                                <% } %>
                        </select>
                    </td>
                </tr>
                        <tr>
                            <td align="right"><input name="aceptar" type="submit" value="aceptar"></td>
                            <td align="left"><input name="cancelar" type="reset" value="cancelar"></td>
                        </tr>
            </form>
        </table>
    </td>
  </tr>
  
  <tr>
    <td colspan="7">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
  </tr>
</table>

</body>
</html>