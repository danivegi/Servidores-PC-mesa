<%@page import="modelo.Comercial"%>
<%@page import="modelo.Bd"%>
<%@page import="modelo.Tienda"%>
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
                <td></td>
                <td><a href="productos.jsp"><img src="imagenes/productos.jpg" width="180" height="123" /></a></td>

            </tr>
            <tr align="center">
                <td><a href="nueva-venta.jsp"><img src="imagenes/nueva-venta.jpg"></img></a></td>
            </tr>
            <tr align="center">
                <td><a href="listado-ventas.jsp"><img src="imagenes/listado-ventas.jpg"></img></a></td>
            </tr>
            <tr>
                <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td> 
            </tr>
            <tr align="center">
                <td colspan="7">

                    <h3>Listado de ventas por comercial</h3>

                    <form method="post" action="rtdo-listado-comercial.jsp">
                    <label>Comercial</label>
                    <select name="sel" id="sel">
                        <%
                            ArrayList<Comercial> listaComerciales = Bd.consultarComerciales();
                            for (int x = 0; x < listaComerciales.size(); x++) {%>
                            <option value="<%=listaComerciales.get(x).getCodigo()%>">
                                <%=listaComerciales.get(x).getNombre()%>
                        </option>
                        <%}%>
                    </select><br></br>
                    
                    <input type="submit" value="Aceptar"></input>
                    <input type="reset" value="Cancelar"></input>
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