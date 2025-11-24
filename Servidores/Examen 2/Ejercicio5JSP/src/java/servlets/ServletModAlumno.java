package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Bd;

public class ServletModAlumno extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dawes = request.getParameter("dawes");
        String dawec = request.getParameter("dawec");
        String diw = request.getParameter("diw");
        String daw = request.getParameter("daw");
        String fct = request.getParameter("fct");
        String proyecto = request.getParameter("proyecto");
        
        String errores = "";
        boolean esValido = true;
        
        if (!compruebaNombre(nombre)) {
            errores += "Nombre";
            esValido = false;
        }
        
        if (!compruebaApellidos(apellidos)) {
            errores += "Apellidos";
            esValido = false;
        }
        
        if (!compruebaDawes(dawes)) {
            errores += "DAWES";
            esValido = false;
        }
        
        if (!compruebaDawec(dawec)) {
            errores += "DAWEC";
            esValido = false;
        }
        
        if (!compruebaDiw(diw)) {
            errores += "DIW";
            esValido = false;
        }
        
        if (!compruebaDaw(daw)) {
            errores += "DAW";
            esValido = false;
        }
        
        if (!compruebaFct(fct)) {
            errores += "FCT";
            esValido = false;
        }
        
        if (!compruebaProyecto(proyecto)) {
            errores += "Proyecto";
            esValido = false;
        }
        
        if (esValido) {
            Alumno a = new Alumno(nombre, apellidos, dawes, dawec, diw, daw, fct, proyecto);
            boolean add = Bd.modificarAlumno(a);
            
            if (add) {
                rd = contexto.getRequestDispatcher("/listado.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("errores.jsp");
                rd.forward(request, response);
            }
        } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("errores.jsp");
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
    
    private boolean compruebaDawes(String dawes) {

        if (dawes.equalsIgnoreCase("Aprobado") || dawes.equalsIgnoreCase("Suspenso")) {
            return true;
        }
        return false;
    }
    
    private boolean compruebaDawec(String dawec) {

        if (dawec.equalsIgnoreCase("Aprobado") || dawec.equalsIgnoreCase("Suspenso")) {
            return true;
        }
        return false;
    }
    
    private boolean compruebaDiw(String diw) {

        if (diw.equalsIgnoreCase("Aprobado") || diw.equalsIgnoreCase("Suspenso")) {
            return true;
        }
        return false;
    }
    
    private boolean compruebaDaw(String daw) {

        if (daw.equalsIgnoreCase("Aprobado") || daw.equalsIgnoreCase("Suspenso")) {
            return true;
        }
        return false;
    }
    
    private boolean compruebaFct(String fct) {

        if (fct.equalsIgnoreCase("Aprobado") || fct.equalsIgnoreCase("Suspenso") || fct.equalsIgnoreCase("Pendiente")) {
            return true;
        }
        return false;
    }
    
    private boolean compruebaProyecto(String proyecto) {

        if (proyecto.equalsIgnoreCase("Aprobado") || proyecto.equalsIgnoreCase("Suspenso") || proyecto.equalsIgnoreCase("Pendiente")) {
            return true;
        }
        return false;
    }
    
}
