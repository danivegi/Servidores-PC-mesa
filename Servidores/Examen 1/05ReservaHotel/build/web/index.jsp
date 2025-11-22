<%@page import="modelo.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

    <head>
        <title>Formulario Reserva</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                align-items: center;
               margin: 10px;
                padding: 8rem;
                
            }
            h1{
              align-self: right;
              
            }
            h2{
                background-color: orange;
            }
        </style>
            
    </head>
    
        <%
    // Obtenemos el contexto de la aplicación (espacio compartido entre todos los servlets y JSP)
    ServletContext contexto = getServletContext();

    // Intentamos recuperar la lista de reservas que se guardó anteriormente en el contexto
    // (esta lista se crea en el ServletReserva cuando se añade una nueva reserva)
    List<Reserva> lista = (List<Reserva>) contexto.getAttribute("lista");

    // Declaramos un RequestDispatcher (aunque aquí no se usa directamente)
    RequestDispatcher rd;

    // Si la lista no existe todavía (por ejemplo, al iniciar la aplicación por primera vez)
    if (lista == null) {
        // Creamos una nueva lista vacía para almacenar reservas
        lista = new ArrayList<Reserva>();

        // La guardamos en el contexto de la aplicación para que otros servlets y JSP puedan acceder a ella
        contexto.setAttribute("lista", lista);
    }
%>
              
        <div id="encabezado">
            <h1>Gestión de Reservas</h1><br>
        </div>
        <form method="post" action="ServletReserva">
        <div id="titulo">
            <h2>Datos Personales</h2><br>
        </div>
        <div id="cuerpo">
            Nombre: <input type="text" name="nombre" required><br>
            Apellidos: <input type="text" name="apellidos" required><br>
            DNI: <input type="text" name="dni" required><br>
            SS: <input type="text" name="seguridadSocial" required><br>
            Telefono:<input type="text" name="tel" required><br>
            E-Mail: <input type="text" name="mail"><br>
            Provincia:<select name="provincia"><br>
                <option value="cadiz">Cadiz</option>
                <option value="huelva">Huelva</option>
                <option value="sevilla">Sevilla</option>
                <option value="malaga">Malaga</option>
                <option value="cordoba">Cordoba</option>
                <option value="jaen">Jaen</option>
                <option value="granada">Granada</option>
                <option value="almeria">Almeria</option>
            </select>
        </div>
        <div id="titulo">
            <h2>Datos de la reserva</h2><br>
        </div>
        <div id="cuerpo">
            Fecha de entrada: <input type="date" name="fechaEntrada" required><br>
            Fecha de Salida: <input type="date" name="fechaSalida" required><br>
            Regimen de alojamiento: <br>
            <input type="radio" name="alojamiento" value="media">
            <label for="alojamiento">Media pensión</label>
            <input type="radio" name="alojamiento" value="completa">
            <label for="alojamiento">Pensión completa</label><br>
            Servicios extras incluidos:<br>
            <input type="checkbox" name="servicios" id="coche" value="coche">
             <label for="servicios">Alquiler de coche</label><br>
            <input type="checkbox" name="servicios" id="excursion" value="excursion">
             <label for="servicios">Excursiones guiadas</label><br>
            <input type="checkbox" name="servicios" id="espectaculo" value="espectaculo">
             <label for="servicios">Espectáculos</label><br>
            <input type="checkbox" name="servicios" id="gimnasio" value="gimnasio">
             <label for="servicios">Gimnasio</label><br>
            <input type="checkbox" name="servicios" id="spa" value="spa">
             <label for="servicios">Spa</label><br>

        </div>
            <input type="submit" name="nuevReserva" value="Añadir Reserva" >
            <input type="reset" name="Borrar" value="Borrar reserva"> <br>
            
        </form>
        <a href="listado.jsp"><button>Ver toda las reservas</button></a>
    

