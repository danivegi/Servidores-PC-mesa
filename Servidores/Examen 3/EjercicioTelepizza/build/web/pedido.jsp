<%@page import="modelo.Bd"%>
<%@page import="modelo.Pizza"%>
<%@page import="java.util.ArrayList"%>
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

        <table height="106" border="0" width="972">
            <tr bordercolor="#FF0000" bgcolor="#FF0000">
                <td height="102" bgcolor="#FF0000">&nbsp;&nbsp; <img src="images/logo_telepizza.gif" width="209" height="43" /></td>
            </tr>
        </table>
        <table width="972" height="106" border="0">
            <%
                ServletContext contexto = getServletContext();
                RequestDispatcher rd;
                String fecha = (String) contexto.getAttribute("fecha");

                HttpSession sesion = request.getSession(false);

                if (sesion == null || sesion.getAttribute("usuario") == null) {
                    rd = contexto.getRequestDispatcher("/Error.html");
                    rd.forward(request, response);
                    return;
                }

            %>

            <tr>
                <p style="color: red"><b>Bienvenida Pepa</b></p> 
                <p style="color: red"><b>Usted a accedido a nuestra zona de pedidos a las <%=fecha%></b></p> 

            </tr>
            <form method="post" action="zona_localizacion.jsp">
                <table>

                    <tr>
                        <td>
                            <label style="color: red">Amantes de la carne </label>
                        </td>
                        <td>
                            <select name="pizzaCarne" id="pizzaCarne">
                                <%
                                    ArrayList<Pizza> listaPizzas = Bd.consultarPizzas("2");
                                    for (int x = 0; x < listaPizzas.size(); x++) {%>
                                <option value="<%=listaPizzas.get(x).getNombre()%>">
                                    <%=listaPizzas.get(x).getNombre()%>
                                </option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="cantidadCarne" id="cantidadCarne">
                                <%
                                for (int x = 0; x <= 10; x++) {%>
                                <option value="<%=x%>"><%=x%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label style="color: red">Los más queseros </label>
                        </td>
                        <td>
                            <select name="pizzaQuesos" id="pizzaQuesos">
                                <%
                                    ArrayList<Pizza> listaPizzasQueso = Bd.consultarPizzas("3");
                                    for (int x = 0; x < listaPizzasQueso.size(); x++) {%>
                                <option value="<%=listaPizzasQueso.get(x).getNombre()%>">
                                    <%=listaPizzasQueso.get(x).getNombre()%>
                                </option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="cantidadQuesos" id="cantidadQuesos">
                                <%
                                for (int x = 0; x <= 10; x++) {%>
                                <option value="<%=x%>"><%=x%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label style="color: red">Los clásicos </label>
                        </td>

                        <td>
                            <select name="pizzaClasicos" id="pizzaClasicos">
                                <%
                                    ArrayList<Pizza> listaPizzasClasicos = Bd.consultarPizzas("4");
                                    for (int x = 0; x < listaPizzasClasicos.size(); x++) {%>
                                <option value="<%=listaPizzasClasicos.get(x).getNombre()%>">
                                    <%=listaPizzasClasicos.get(x).getNombre()%>
                                </option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="cantidadClasicos" id="cantidadClasicos">
                                <%
                                for (int x = 0; x <= 10; x++) {%>
                                <option value="<%=x%>"><%=x%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label style="color: red">Infantil </label>
                        </td>
                        <td>
                            <select name="pizzaInfantil" id="pizzaInfantil">
                                <%
                                    ArrayList<Pizza> listaPizzasInfantil = Bd.consultarPizzas("6");
                                    for (int x = 0; x < listaPizzasInfantil.size(); x++) {%>
                                <option value="<%=listaPizzasInfantil.get(x).getNombre()%>">
                                    <%=listaPizzasInfantil.get(x).getNombre()%>
                                </option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="cantidadInfantil" id="cantidadInfantil">
                                <%
                                for (int x = 0; x <= 10; x++) {%>
                                <option value="<%=x%>"><%=x%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label style="color: red">Sin gluten </label>
                        </td>
                        <td>
                            <select name="pizzaNatural" id="pizzaNatural">
                                <%
                                    ArrayList<Pizza> listaPizzasNaturales = Bd.consultarPizzas("5");
                                    for (int x = 0; x < listaPizzasNaturales.size(); x++) {%>
                                <option value="<%=listaPizzasNaturales.get(x).getNombre()%>">
                                    <%=listaPizzasNaturales.get(x).getNombre()%>
                                </option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="cantidadNaturales" id="cantidadNaturales">
                                <%
                                for (int x = 0; x <= 10; x++) {%>
                                <option value="<%=x%>"><%=x%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>


                </table>
                <br>
                    <input type="submit" value="Confirmar pedido">
                        </form>
                        <table width="100%" height="106" border="0">
                            <tr >
                                <td ><img src="images/pie.gif" width="972" height="51" /></td>
                            </tr>
                        </table>

                        </body>
                        </html>