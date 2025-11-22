<%@page import="modelo.Bd"%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>
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
                    </td>
                    <td>
                        <a href="listado-productos.jsp">
                            <img src="imagenes/listado-productos.jpg" width="180" height="80"/>
                        </a>
                    </td>
                </tr>

                <tr align="center">
                    <td>
                    </td>
                    <td>
                        <a href="nuevo-producto.jsp">
                            <img src="imagenes/nuevo-producto.jpg" width="180" height="80"/>
                        </a>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                    </td>
                    <td>
                        <a href="modificar-producto.jsp">
                            <img src="imagenes/modificar-producto.jpg" width="180" height="80"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
                </tr>

                <tr>
                    <form action="ServletProducto" method="post">
                        <td colspan="7" align="center">
                            <h3>Añadir un nuevo producto</h3>

                            <label>Referencia</label>
                            <input type="text" name="ref" id="ref"></input><br><br>
                                    <label>Nombre</label>
                                    <input type="text" name="nombre" id="nombre"></input><br><br>
                                            <label>Descripción</label>
                                            <input type="text" name="desc" id="desc"></input><br><br>
                                                    <label>Precio</label>
                                                    <input type="text" name="precio" id="precio"></input><br><br>
                                                            <label>Descuento</label>
                                                            <input type="text" name="dto" id="dto"></input><br><br>
                                                                    <input type="submit" value="Aceptar"></input>
                                                                    <input type="reset" value="Cancelar"></input>
                                                                    </td>
                                                                    </form>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
                                                                    </tr>
                                                                    </table>

                                                                    </body>
                                                                    </html>