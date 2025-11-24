package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
        if (usuario.equals("lolo") && clave.equals("1111")) {
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else if (usuario.equals("alumno") && clave.equals("1234")) {
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/error.html");
            rd.forward(request, response);
        }
    }

}