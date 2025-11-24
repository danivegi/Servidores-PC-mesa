package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bd;
import modelo.Comercial;
import modelo.Venta;

public class ServletComerciales extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String salario = request.getParameter("salario");
        String fecha = request.getParameter("fecha");
        String hijos = request.getParameter("hijos");

        String errores = "";
        boolean esValido = true;
        
        if (!compruebaCodigo(codigo)) {
            errores += " Codigo ";
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

        if (!compruebaFecha(fecha)) {
            errores += " Fecha ";
            esValido = false;
        }
        
        if (!compruebaHijos(hijos)) {
            errores += " Hijos ";
            esValido = false;
        }

        if (esValido) {
            LocalDate f = LocalDate.parse(fecha);
            int hijosNumb = Integer.parseInt(hijos);
            double salarioNumb = Double.parseDouble(salario);

            Comercial nuevoComercial = new Comercial(codigo, nombre, salarioNumb, hijosNumb, f);

            boolean add = Bd.nuevoComercial(nuevoComercial);
            if (add) {
                rd = contexto.getRequestDispatcher("/listado-comerciales.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("/errorAlta.jsp");
                rd.forward(request, response);
            }
        } else {
            contexto.setAttribute("errores", errores);
            rd = contexto.getRequestDispatcher("/errorAlta.jsp");
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
            double salarioNumb = Double.parseDouble(salario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private boolean compruebaFecha(String fecha) {
        if (fecha.length() <= 0) {
            return false;
        }
        LocalDate f = null;
        try {
            f = LocalDate.parse(fecha);
            
            if (f.isAfter(LocalDate.now())) {
                return false;
            }
        } catch(Exception e) {
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
