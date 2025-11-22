<%@page import="java.util.ArrayList"%>
<%@page import="md.Libro"%>
<%@page pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Resultado</title>
        </head>
        <body bgcolor="#e2e3f8">
            <%
                String dato = request.getParameter("titulo");
                ArrayList<Libro> lista=md.Bd.consultaTitulos(dato);
            %>
            <h1>Consulta de los titulos disponibles:</h1>
            <div align="center">
                <table border="1" aling="center">
                    <tr>
                        <td>TITULO</td>
                        <td>ISBN</td>
                        <td>AUTOR </td>
                        <td>EDITORIAL</td>
                        <td>DESCRIPCION</td>
                    </tr>
                    <%
                    for (int i=0;i<lista.size();++i){ {%>
                        <td><%=lista.get(i).getTitulo()%></td>
                        <td><%=lista.get(i).getIsbn()%></td>
                        <td><%=lista.get(i).getAutor()%></td>
                        <td><%=lista.get(i).getEditorial()%></td>
                        <td><%=lista.get(i).getDescripcion()%></td>
                        <%}%>
                        </tr>
                    <%}%>
                </table>
                <a href="index.jsp">Volver a la pagina principal</a>
            </div>
            </body>
    </html>