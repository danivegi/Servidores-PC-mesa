<%@page import="modelo.Bd"%>
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
                <td><a href="ventas.jsp"><img src="imagenes/ventas.jpg" width="180" height="123" /></a></td>
                <td><a href="productos.jsp"><img src="imagenes/productos.jpg" width="180" height="123" /></a></td>
                <td><a href="comerciales.jsp"><img src="imagenes/comerciales.jpg" alt="" width="180" height="123" /></a></td>

            </tr>
            <tr align="center">
                <td><a href="listado-ventas.jsp"><img src="imagenes/listado-ventas.jpg"></a></td>
            </tr>
            <tr align="center">
                <td><a href="nueva-venta.jsp"><img src="imagenes/nueva-venta.jpg"></a></td>
            </tr>
            <tr>
                <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
            </tr>



            <tr align="center">
                <td></td>
                <form action="rtdo-listado-productos.jsp" method="post">
                <td>
                    <h3>Listado de ventas</h3>
                    <br>
                        <label>Producto</label>
                        <select name="sel" id="sel">
                            <%
                                ArrayList<Producto> listaProductos = new ArrayList<Producto>();
                                listaProductos = Bd.consultarProductos();

                                for (int x = 0; x < listaProductos.size(); x++) {%>
                            <option value="<%=listaProductos.get(x).getReferencia()%>">
                                <%=listaProductos.get(x).getReferencia()%> - <%=listaProductos.get(x).getNombre()%>
                            </option>
                            <%}%>
                        </select>
                        <br></br>
                        <input type="submit" value="aceptar"> <input type="reset" value="cancelar">
                                </td>
                        </form>
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