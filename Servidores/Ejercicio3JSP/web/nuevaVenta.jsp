<%@page import="modelo.Comercial"%>
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
            <a href="listado-ventas.jsp?opcion=listado">
            <img src="imagenes/listado-ventas.jpg" width="180" height="80"/>
            </a>
        </td>
    </tr>
      
    <tr align="center">
        <td>
            <a href="nuevaVenta.jsp?opcion=nueva">
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
            <form id="form1" name="form1" method="post" action="ServletVenta">
                <tr align="center">
                    <td colspan="2"><h3>Añadir una nueva venta</h3></td>
                </tr>
                <tr align="center">
                    <td width="50%" align="right">Comercial
                        <select id="com" name="com">
                            <option value="0">Seleccione un comercial</option>
                            <% 
                                ArrayList<Comercial> listaComerciales = modelo.Bd.consultarComerciales();
                            
                                for (int x = 0; x < listaComerciales.size(); x++) {%>
                                <option value="<%=listaComerciales.get(x).getCodigo().toString()%>">
                                    <%=listaComerciales.get(x).getCodigo().toString()%> - <%=listaComerciales.get(x).getNombre()%>
                                </option>
                                <%}%>
                        </select>
                        </td>
                </tr>
                        
                        <tr align="center">
                        <td width="50%" align="right">Producto
                        <select id="prod" name="prod">
                            <option value="0">Seleccione un producto</option>
                            <% 
                                ArrayList<Producto> listaProductos = modelo.Bd.consultarProductos();
                            
                                for (int x = 0; x < listaProductos.size(); x++) {%>
                                <option value="<%=listaProductos.get(x).getRef().toString()%>">
                                    <%=listaProductos.get(x).getRef().toString()%> - <%=listaProductos.get(x).getNombre()%>
                                </option>
                                <%}%>
                        </select>
                        </td>
                    </td>
                </tr>
                        
                        <tr align="center">
                            <td width="50%" align="right">
                                <label>Cantidad</label>
                                <input type="text" name="cantidad" id="cantidad"></input>
                            </td>
                        </tr>
                        <tr align="center">
                            <td width="50%" align="right">
                                <label>Fecha de vta</label>
                                <input type="text" name="fechaVenta" id="fechaVenta"></input>
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