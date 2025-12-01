package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bd;
import modelo.Comercial;

public class ServletComercial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String salario = request.getParameter("salario");
        String fNacimiento = request.getParameter("fNacimiento");
        String hijos = request.getParameter("hijos");

        String errores = "";
        boolean esValido = true;

        if (!compruebaCodigo(codigo)) {
            errores += "Codigo ";
            esValido = false;
        }

        if (!compruebaNombre(nombre)) {
            errores += " Nombre ";
            esValido = false;
        }

        if (!compruebaSalario(salario)) {
            errores += " Salario ";
            esValido = false;
        }

        if (!compruebaFecha(fNacimiento)) {
            errores += " Fecha ";
            esValido = false;
        }

        if (!compruebaHijos(hijos)) {
            errores += " Hijos ";
            esValido = false;
        }

        if (esValido) {
            LocalDate f = LocalDate.parse(fNacimiento);
            double sal = Double.parseDouble(salario);
            int h = Integer.parseInt(hijos);

            Comercial c = new Comercial(codigo, nombre, sal, h, f);
            boolean add = Bd.nuevoComercial(c);
            if (add) {
                rd = contexto.getRequestDispatcher("/listado-comerciales.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("/errores.jsp");
                rd.forward(request, response);
            }
        } else {
            contexto.setAttribute("errores", errores);
            rd = contexto.getRequestDispatcher("/errores.jsp");
            rd.forward(request, response);
        }

    }

    private boolean compruebaCodigo(String codigo) {
        if (codigo.length() <= 0) {
            return false;
        }
        for (int x = 0; x < codigo.length(); x++) {
            char c = codigo.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
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

    private boolean compruebaSalario(String salario) {
        if (salario.length() <= 0) {
            return false;
        }
        try {
            double p = Double.parseDouble(salario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean compruebaFecha(String fNacimiento) {
        if (fNacimiento.length() <= 0) {
            return false;
        }

        try {
            LocalDate f = LocalDate.parse(fNacimiento);
            if (f.isAfter(LocalDate.now())) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean compruebaHijos(String hijos) {
        if (hijos.length() <= 0) {
            return false;
        }
        for (int x = 0; x < hijos.length(); x++) {
            char c = hijos.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
