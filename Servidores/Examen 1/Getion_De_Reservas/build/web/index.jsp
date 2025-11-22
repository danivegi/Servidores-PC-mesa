<%@page import="modelo.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Agenda de Actividades Extraescolares</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="">
    </head>
    
    <%
        ServletContext contexto = getServletContext();
        List<Reserva> lista = (List<Reserva>) contexto.getAttribute("lista");
        RequestDispatcher rd;
        if (lista == null) {
            lista = new ArrayList<Reserva>();
            contexto.setAttribute("lista", lista);
        }
     %>
   <body>
    <table width="710" border="1">
          <tr>
            <td>
       
          
        <table width="710" border="0">
          <tr>
            <td width="232"><img src="Logo1.png" alt="" width="200" height="200"></td>
            <td width="462" align="center"><h1>Gestión de Reservas</h1></td>
          </tr>
        </table>
       
        <table width="710" height="351" border="0">
            <form method="POST" action="ReservaServlet">
                <tr>
                    <td colspan="3" bgcolor="#D3A66D">Datos personales </td>
                </tr>
                 <tr>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td width="175">Nombre:</td>
                    <td colspan="2"><input name="nombre" type="text"  size="20"></td>
                </tr>
                 <tr>
                    <td width="175">Apellidos:</td>
                    <td colspan="2"><input name="apellidos" type="text"  size="50"></td>
                </tr>
                <tr>
                    <td width="175">DNI:</td>
                    <td colspan="2"><input name="dni" type="text"  size="9"></td>
                </tr>
                <tr>
                    <td width="175">SS:</td>
                    <td colspan="2"><input type="text" name="ss"  ></td>
                </tr>
                <tr>
                    <td width="175">telefono:</td>
                    <td colspan="2"><input name="telefono" type="text"  size="12"></td>
                </tr>
                <tr>
                    <td width="175">email:</td>
                    <td colspan="2"><input name="email" type="mail"   size="30"></td>
                </tr>
                <tr>
                  <td>Provincia: </td>
                  <td colspan="2">
                      <select name="provincia">
                          <option>Huelva</option>
                          <option>Sevilla</option>
                          <option>Cadiz</option>
                          <option>Cordoba</option>
                          <option>Málaga</option>
                          <option>Jaen</option>
                          <option>Granada</option>
                          <option>Almeria</option>
                    </select>
                  </td>
                </tr>
                <tr>
                    <td colspan="3" bgcolor="#D3A66D">Datos de la reserva</td>
                </tr>
                 <tr>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td>Fecha de entrada: </td><td colspan="2"><input type="date" name="fechaEntrada" ></td>
                </tr>
                <tr>
                    <td>Fecha de salida: </td>
                    <td colspan="2"><input type="date" name="fechaSalida" ></td>
                </tr>
                <tr>
                    <td>Ragimen de alojamiento: </td>
                    <td colspan="2"><input type="radio" name="alojamiento" value="Media Pension" />
                      Media pension
                        <input type="radio" name="alojamiento" value="Pension Completa" />
                        Pension completa</td>
                </tr>
                <tr>
                  <td>Servicios extras incluidos:</td>
                  <td colspan="2">
                   <input type="checkbox" id="extras" name="extras" value="coche" />
                    Coche de alquiler <br> 
                       <input type="checkbox" id="extras" name="extras" value="excursion" />
                       Excursiones<br>
                       <input type="checkbox" id="extras" name="extras" value="espectaculos" />
                       Espectaculos <br> 
                     <input type="checkbox" id="extras" name="extras" value="gimnasio"/>
                     Gimnasio<br>
                     <input type="checkbox" id="extras" name="extras" value="spa"/>
                     SPA<br></td>
                  </tr> 
                 <tr>
                    <td colspan="3" align="center"><input type="submit" value="Añadir reserva">
                      &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;                      
                      <input type="reset" value="Borrar reserva"></td>
                </tr> 
            </form>
        </table> 
        
   <table width="705" >
          <tr><td width="636" align="center">
           
        <form name="verCarro" action="listado.jsp" method="POST">
            <input type="submit" value="Ver Reservas" name="verCarro" >
        </form>
  </td></tr></table>
  </td></tr></table>
   
</body>
        
   
</html>