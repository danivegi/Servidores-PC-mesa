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
                    </td>
                    <td>
                    </td>
                    <td>
                        <a href="listado-comerciales.jsp">
                            <img src="imagenes/listado-comerciales.jpg" width="180" height="80"/>
                        </a>
                    </td>
                </tr>

                <tr align="center">
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                        <a href="alta-comercial.jsp">
                            <img src="imagenes/alta-comerciales.jpg" width="180" height="80"/>
                        </a>
                    </td>
                </tr>

                <tr>
                    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
                </tr>

                <tr align="center">
                    <td></td>
                    <td>
                        <h3>Añadir un nuevo comercial</h3>


                        <form action="ServletComerciales" method="post">
                            <label>Código</label>
                            <input type="text" name="codigo" id="codigo"></input><br><br>
                                    <label>Nombre</label>
                                    <input type="text" name="nombre" id="nombre"></input><br><br>
                                            <label>Salario</label>
                                            <input type="text" name="salario" id="salario"></input><br><br>
                                                    <label>Fecha de Nacimiento</label>
                                                    <input type="text" name="fecha" id="fecha"></input><br><br>
                                                            <label>Número de hijos</label>
                                                            <input type="text" name="hijos" id="hijos"></input><br><br>
                                                                    <input name="aceptar" type="submit" value="aceptar">
                                                                        <input name="cancelar" type="reset" value="cancelar">
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