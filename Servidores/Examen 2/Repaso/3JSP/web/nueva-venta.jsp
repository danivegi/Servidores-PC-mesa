<%@page import="modelo.Comercial"%>
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
                <form action="ServletVenta" method="post">
                    <td>
                        <h3>Añadir una nueva venta</h3>
                        <br>
                            <form action="ServletVenta" method="post">
                                <label>Comercial</label>
                                <select name="comercial" id="comercial">
                                    <option value="0">
                                        Selecciona un comercial
                                    </option>
                                <%
                                    ArrayList<Comercial> listaComerciales = Bd.consultarComerciales();

                                    for (int x = 0; x < listaComerciales.size(); x++) {%>
                                    
                                    <option value="<%=listaComerciales.get(x).getCodigo()%>">
                                        <%=listaComerciales.get(x).getCodigo()%> - <%=listaComerciales.get(x).getNombre()%>
                                    </option>
                                    <%}%>  
                                </select> <br></br>

                                <label>Producto</label>
                                <select name="producto" id="producto">
                                    <option value="0">
                                        Selecciona un producto
                                    </option>
                                    <%
                                        ArrayList<Producto> listaProductos = Bd.consultarProductos();
                                        for (int x = 0; x < listaProductos.size(); x++) {%>
                                        <option value="<%=listaProductos.get(x).getReferencia()%>">
                                            <%=listaProductos.get(x).getReferencia()%> - <%=listaProductos.get(x).getNombre()%>
                                        </option>
                                        <%}%>    

                                </select><br></br>

                                <label>Cantidad</label>
                                <input type="text" name="cantidad" id="cantidad"></input><br></br>

                                <label>Fecha de venta</label>
                                <input type="text" name="fecha" id="fecha"></input><br></br>

                                <input type="submit" value="aceptar"></input>
                                <input type="reset" value="cancelar"></input>
                            </form>
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