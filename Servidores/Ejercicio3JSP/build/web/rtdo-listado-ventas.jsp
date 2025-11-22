<%@page import="modelo.Bd"%>
<%@page import="modelo.Venta"%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin t?tulo</title>
    </head>

    <%
        ServletContext contexto = getServletContext();

        String opcion;
        if (request.getParameter("opcion") != null) {
            opcion = request.getParameter("opcion");
        } else {
            opcion = "";
        }
    %>

    <body>

        <table width="100%" border="0">
            <tr>
                <td colspan="7" bgcolor="#333333">&nbsp;</td>
            </tr>
            <tr align="center">
                <td colspan="7" bgcolor="#CCCCCC"><h1>APLICACI?N DE GESTI?N COMERCIAL</h1></td>
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
                        <a href="ventas.jsp?opcion=nueva">
                            <img src="imagenes/nueva-venta.jpg" width="180" height="80"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="7">
                        <%
                            String productoref = request.getParameter("sel");
                            ArrayList<Venta> listaVentas = Bd.consultarVentas(productoref);
                        %>
                        <h2><%=productoref%></h2>
                        <table width="50%" border="0" align="center">
                          
                                            <tr align="center" bgcolor="#CCCCCC">
                                                <td><b>Fecha</b></td>
                                                <td><b>Comercial</b></td>
                                                <td><b>Producto</b></td>
                                                <td><b>Cantidad</b></td>
                                                <td><b>Precio</b></td>
                                                <td><b>Total</b></td>
                                                <td><b>Descuento</b></td>
                                                <td><b>Total Descuento</b></td>
                                            </tr>

                                            <% for (Venta v : listaVentas) {
                                                    double totaldescuento = v.getTotal() - (v.getTotal() * v.getDescuento() / 100);


                                            %> 
                                            <tr align="center">
                                                <td><%=v.getFecha().toString()%></td>
                                                <td><%=v.getComercial()%></td>
                                                <td><%=v.getProducto()%></td>
                                                <td><%=v.getCantidad()%></td>
                                                <td><%=v.getPrecio()%></td>
                                                <td><%=Math.floor(v.getTotal())%></td>
                                                <td><%=v.getDescuento()%></td>
                                                <td><%=totaldescuento%></td>

                                            </tr> <%}%>
                                    </td>
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