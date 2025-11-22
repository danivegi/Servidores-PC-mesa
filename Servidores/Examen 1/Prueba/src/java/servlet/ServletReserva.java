package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Reserva;

public class ServletReserva extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String ss = request.getParameter("ss");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String provincia = request.getParameter("provincia");
        String fechaEntrada = request.getParameter("fechaEntrada");
        String fechaSalida = request.getParameter("fechaSalida");
        String alojamiento = request.getParameter("alojamiento");
        String[] extras = request.getParameterValues("extras");

        boolean esValido = true;
        String error = "";
        
        if(!compruebaNombre(nombre)) {
            esValido = false;
            error= " Nombre ";
        }
        
        if(!compruebaApellidos(apellidos)) {
            esValido = false;
            error += " Apellidos ";
        }
        
        if (!compruebaDni(dni)) {
            esValido = false;
            error += " Dni ";
        }
        
        if (!compruebaSS(ss)) {
            esValido = false;
            error += " SS ";
        }
        
        if (!compruebaTelefono(telefono)) {
            esValido = false;
            error += " Telefono ";
        }
        
        if (!compruebaEmail(email)) {
            esValido = false;
            error += " Email ";
        }
        
        if (!compruebaFechas(fechaEntrada, fechaSalida)) {
            esValido = false;
            error += " Fecha ";
        }
        
        if (!compruebaAlojamiento(alojamiento)) {
            esValido = false;
            error += " Alojamiento ";
        }
        
        if(esValido) {
            Reserva nuevaReserva = new Reserva(nombre, apellidos, dni, ss, telefono, email, provincia, fechaEntrada, fechaSalida, alojamiento, extras);
            List<Reserva> lista = (List<Reserva>) contexto.getAttribute("lista");
            lista.add(nuevaReserva);
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            contexto.setAttribute("errores", error);
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
         

    }

    private boolean compruebaNombre(String nombre) {
        if (nombre.length() <= 0) {
            return false;
        }
        for (int x = 0; x < nombre.length(); x++) {
            char c = nombre.charAt(x);
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean compruebaApellidos(String apellidos) {
        if (apellidos.length() <= 0) {
            return false;
        }
        for (int x = 0; x < apellidos.length(); x++) {
            char c = apellidos.charAt(x);
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean compruebaDni(String dni) {
        if (dni.length() != 9) {
            return false;
        }

        String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        for (int x = 0; x < numeros.length(); x++) {
            char c = numeros.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int num = Integer.parseInt(numeros);
        int resto = num % 23;
        char letraCorrecta = letras.charAt(resto);

        if (letra != letraCorrecta) {
            return false;
        }
        return true;
    }

    private boolean compruebaSS(String ss) {
        if (ss.length() != 12) {
            return false;
        } else {

        }
        for (int x = 0; x < ss.length(); x++) {
            char c = ss.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        String[] provincias = {"01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63",
            "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20",
            "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85",
            "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75",
            "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49",
            "50", "99", "51", "52"};

        String codProv = ss.substring(0, 2);
        for (int x = 0; x < provincias.length; x++) {
            if (provincias[x].equals(codProv)) {
                return true;
            }
        }

        return false;
    }

    private boolean compruebaTelefono(String telefono) {
        if (telefono.length() != 12 && telefono.length() != 9) {
            return false;
        }

        if (telefono.length() == 12) {
            String prefijo = telefono.substring(0, 3);
            String numero = telefono.substring(3, 12);
            if (!prefijo.equals("+34")) {
                return false;
            }
            for (int x = 0; x < numero.length(); x++) {
                char c = numero.charAt(x);
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        } else if (telefono.length() == 9) {
            for (int x = 0; x < telefono.length(); x++) {
                char c = telefono.charAt(x);
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }
    
    
    private boolean compruebaEmail(String email) {
        if (email.length() > 0) {
            int contador = 0;
            for (int x = 0; x < email.length(); x++) {
                char c = email.charAt(x);
                if (c == '@') {
                    contador++;
                }
                if (c == '.') {
                    contador++;
                }
            }
            if (contador < 2) {
                return false;
            }
        }
        return true;
    }
    
    
    private boolean compruebaFechas(String fechaEntrada, String fechaSalida) {
        if (fechaEntrada.length() <= 0 || fechaSalida.length() <= 0) {
            return false;
        }
        LocalDate fecha1 = LocalDate.parse(fechaEntrada);
        LocalDate fecha2 = LocalDate.parse(fechaSalida);
        long dias = ChronoUnit.DAYS.between(fecha1, fecha2);
        if (dias > 7 || dias < 1) {
            return false;
        }
        return true;
    }
    
    
    private boolean compruebaAlojamiento(String alojamiento) {
        if (alojamiento == null) {
            return false;
        }
        return true;
    }

}
