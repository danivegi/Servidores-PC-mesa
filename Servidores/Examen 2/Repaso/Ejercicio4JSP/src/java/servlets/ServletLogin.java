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
        
        if (usuario.equals("user1") && clave.equals("1111")) {
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else if (usuario.equals("user2") && clave.equals("2222")) {
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else if (usuario.equals("user3") && clave.equals("3333")) {
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else if (usuario.equals("user4") && clave.equals("4444")) {
            rd = contexto.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else if (usuario.length() <= 0 || clave.length() <= 0) {
            rd = contexto.getRequestDispatcher("/errorCV.html");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/errorLogin.html");
            rd.forward(request, response);
        }
        
    }

}
