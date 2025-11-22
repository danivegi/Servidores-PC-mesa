/*
 * ServletReserva: Controla la recepción de los datos del formulario de reserva,
 * valida los campos introducidos por el usuario y, si todo está correcto,
 * crea una nueva reserva y la guarda en una lista compartida en el contexto.
 */

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Reserva;  // Importa la clase modelo que representa una reserva

/**
 * Servlet que gestiona las peticiones de reserva de hotel.
 */
@WebServlet(name = "ServletReserva", urlPatterns = {"/ServletReserva"})
public class ServletReserva extends HttpServlet {

    /**
     * Método que procesa las peticiones POST (cuando el usuario envía el formulario).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos el contexto de la aplicación (espacio compartido entre servlets)
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        // Recuperamos los datos enviados desde el formulario HTML mediante sus "name"
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String seguridadSocial = request.getParameter("seguridadSocial");
        String telefono = request.getParameter("tel");
        String mail = request.getParameter("mail");
        String provicia = request.getParameter("provincia");  // ojo: "provicia" está mal escrito
        String fechaEntrada = request.getParameter("fechaEntrada");
        String fechaSalida = request.getParameter("fechaSalida");
        String alojamiento = request.getParameter("alojamiento");
        String servicios[] = request.getParameterValues("servicios"); // array (checkboxes)

        // Variables de control para verificar si los datos son válidos
        boolean datosValidos = true;
        String error = "Errores encontrados:";

        // Comprobamos uno por uno los campos críticos (DNI, Seguridad Social, Fechas)
        if (!compruebaDni(dni)) {
            datosValidos = false;
            error += " DNI";
        }

        if (!compruebaSS(seguridadSocial)) {
            datosValidos = false;
            error += " Número de Seguridad Social";
        }

        if (!compruebaFecha(fechaEntrada, fechaSalida)) {
            datosValidos = false;
            error += " Fechas";
        }

        // Si todos los datos son válidos, creamos una nueva reserva
        if (datosValidos) {
            // Se crea un objeto Reserva con todos los datos introducidos
            Reserva nuevaReserva = new Reserva(nombre, apellidos, dni, seguridadSocial,
                                               telefono, mail, fechaEntrada, fechaSalida,
                                               alojamiento, provicia, servicios);

            // Recuperamos la lista de reservas guardada en el contexto (ámbito global de la aplicación)
            List<Reserva> lista = (ArrayList<Reserva>) getServletContext().getAttribute("lista");

            // Añadimos la nueva reserva a la lista existente
            lista.add(nuevaReserva);

            // Redirigimos al usuario a la página principal (index.jsp)
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        } else {
            // Si hay errores, guardamos el mensaje y redirigimos a una página de error
            contexto.setAttribute(error, "errores"); // ⚠️ Esto parece invertido: debería ser ("errores", error)
            rd = contexto.getRequestDispatcher("/error.html");
            rd.forward(request, response);
        }
    }

    /**
     * Valida el formato del DNI.
     * Comprueba que tenga 8 números + 1 letra y que la letra sea la correcta según el cálculo oficial.
     */
    private boolean compruebaDni(String dni) {
        boolean dniCorrecto = true;

        // El DNI debe tener 9 caracteres (8 números + 1 letra)
        if (dni.length() != 9) {
            return false;
        }

        // Letras válidas según el resto del número dividido por 23
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Extraemos el número y la letra del DNI
        String numeroStr = dni.substring(0, 8);
        char letra = Character.toUpperCase(dni.charAt(8));

        // Convertimos el número a entero y calculamos la letra esperada
        int numero = Integer.parseInt(numeroStr);
        char letraEsperada = letras.charAt(numero % 23);

        // Comparamos con la letra introducida
        if (letra != letraEsperada) {
            dniCorrecto = false;
        }

        return dniCorrecto;
    }

    /**
     * Valida el número de Seguridad Social.
     * Comprueba que tenga 12 dígitos y que los dos primeros correspondan a un código de provincia válido.
     */
    private boolean compruebaSS(String seguridadSocial) {
        boolean ssCorrecta = true;

        // Debe tener exactamente 12 caracteres
        if (seguridadSocial.length() != 12) {
            return false;
        }

        // Los dos primeros dígitos corresponden al código de provincia
        String codProvincia = seguridadSocial.substring(0, 2);

        // Lista de todos los códigos válidos de provincia
        String numerosProvincias[] = {"01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59",
            "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17",
            "55", "18", "19", "20", "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81",
            "82", "83", "84", "85", "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36",
            "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98",
            "47", "48", "95", "49", "50", "99", "51", "52"};

        // Recorremos el array para ver si el código existe
        for (int x = 0; x < numerosProvincias.length; x++) {
            if (codProvincia.equals(numerosProvincias[x])) {
                ssCorrecta = true;
                break;
            } else {
                ssCorrecta = false;
            }
        }
        return ssCorrecta;
    }

    /**
     * Comprueba que la fecha de salida no sea más de 7 días posterior a la fecha de entrada.
     * Devuelve false si la estancia supera los 7 días.
     */
    private boolean compruebaFecha(String fechaEntrada, String fechaSalida) {
        boolean fechaCorrecta = true;

        // Convierte las cadenas del formulario en objetos LocalDate
        LocalDate date1 = LocalDate.parse(fechaEntrada);
        LocalDate date2 = LocalDate.parse(fechaSalida);

        // Calcula la diferencia en días entre ambas fechas
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(date1, date2);

        // Si la diferencia es mayor a 7 días, la fecha no es válida
        if (daysBetween > 7) {
            fechaCorrecta = false;
        }

        return fechaCorrecta;
    }
}
