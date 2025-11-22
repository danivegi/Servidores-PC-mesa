package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

public class ServletCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String nombreEmpresa = request.getParameter("nombreEmpresa");
        String cif = request.getParameter("cif");
        String representante = request.getParameter("representante");
        String nif = request.getParameter("nif");
        String sector = request.getParameter("sector");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String ventas = request.getParameter("ventas");
        String observaciones = request.getParameter("observaciones");

        boolean esValido = true;
        String error = "Errores encontrados: ";

        if (!compruebaNombre(nombreEmpresa)) {
            esValido = false;
            error += " Nombre ";
        }
        
        if (!compruebaRepresentante(representante)) {
            esValido = false;
            error += " Representante ";
        }
        
        if (!compruebaSector(sector)) {
            esValido = false;
            error += " Sector ";
        }
        
        if (!compruebaTelefono(telefono)) {
            esValido = false;
            error += " Telefono ";
        }
        
        if (!compruebaEmail(email)) {
            esValido = false;
            error += " Email ";
        }
        
        if (!compruebaVentas(ventas)) {
            esValido = false;
            error += " Ventas ";
        }
        
        if (!compruebaNif(nif)) {
            esValido = false;
            error += " Nif ";
        }
        
        if (!compruebaCifO(cif) || !compruebaCifC(cif) || !compruebaCifN(cif) || !compruebaCifP(cif)){
            esValido = false;
            error += " Cif ";
        }
        
        if (esValido) {
            Cliente nuevoCliente = new Cliente(nombreEmpresa, cif, representante, nif, sector, telefono, email, ventas, observaciones);
            List<Cliente> lista = (ArrayList<Cliente>) getServletContext().getAttribute("lista");
            lista.add(nuevoCliente);
            rd = contexto.getRequestDispatcher("/listado.jsp");
            rd.forward(request, response);
        } else {
            contexto.setAttribute("errores", error);
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
    }

    private boolean compruebaNombre(String nombreEmpresa) {
        if (nombreEmpresa.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaRepresentante(String representante) {
        if (representante.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaSector(String sector) {
        if (sector.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaTelefono(String telefono) {
        if (telefono.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaEmail(String email) {
        if (email.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaVentas(String ventas) {
        if (ventas.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaNif(String nif) {
        if (nif.length() != 9) {
            return false;
        }
        String numeros = nif.substring(0, 8);
        char letraNif = nif.charAt(8);

        for (int x = 0; x < numeros.length(); x++) {
            char c = numeros.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int num = Integer.parseInt(numeros);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        int resto = num % 23;
        char letraCorrecta = letras.charAt(resto);

        if (letraNif != letraCorrecta) {
            return false;
        }
        return true;
    }

    private boolean compruebaCifO(String cif) {
        String letraO = cif.substring(0, 1);
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U", "V", "W"};
        for (int x = 0; x < letras.length; x++) {
            if (letras[x].equals(letraO)) {
                return true;
            }
        }
        return false;
    }

    private boolean compruebaCifP(String cif) {
        String[] provincias = {"01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09",
            "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23",
            "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31",
            "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44",
            "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51", "52"};

        String letrasP = cif.substring(1, 3);
        for (int x = 0; x < provincias.length; x++) {
            if (provincias[x].equals(letrasP)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean compruebaCifN(String cif) {
        String numeros = cif.substring(1, 8);
        
        for (int x = 0; x < numeros.length(); x++){
            char c = numeros.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean compruebaCifC(String cif) {
        String cifMayus = cif.toUpperCase();
        char letra = cifMayus.charAt(0);
        char letraControl = cifMayus.charAt(8);
        
        if((letra == 'K' || letra == 'P' || letra == 'Q' || letra == 'S') && !Character.isDigit(letraControl)) {
            return true;
        } else if ((letra == 'A' || letra == 'B' || letra == 'E' || letra == 'H') && Character.isDigit(letraControl)) {
            return true;
        }
        return false;
    }
    
    

}
