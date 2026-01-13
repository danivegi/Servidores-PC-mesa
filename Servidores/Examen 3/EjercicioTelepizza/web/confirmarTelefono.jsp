<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>

        <style type="text/css">
            body {
                background-color: #FFFFFF;
            }
        </style>
    </head>

    <body>
        <%
            HttpSession sesion = request.getSession(false);
            ServletContext contexto = getServletContext();
            RequestDispatcher rd;
            
            if (sesion == null || sesion.getAttribute("usuario") == null) {
                rd = contexto.getRequestDispatcher("/Error.html");
                rd.forward(request, response);
                return;
            }
        %>
        <table height="106" border="0" width="972">
            <tr bordercolor="#FF0000" bgcolor="#FF0000">
                <td height="102" bgcolor="#FF0000">&nbsp;&nbsp; <img src="images/logo_telepizza.gif" width="209" height="43" /></td>
            </tr>
        </table>
        <table width="972" height="106" border="0" align="center">
            <form method="post" action="ServletTelefono">
                <p style="color:red"><b>Pepa debe indicar su teléfono para confirmar el pedido</b></p>
                
                <input type="text" name="telefono" id="telefono"> <br><br>
                    
                    <input type="submit" value="Tramitar pedido">
            </form>

        </table>
        <table width="100%" height="106" border="0">
            <tr >
                <td ><img src="images/pie.gif" width="972" height="51" /></td>
            </tr>
        </table>

    </body>
</html>