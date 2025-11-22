package servlet;

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
        String password = request.getParameter("password");

        if (password.equals("trebujena")) {
            rd = contexto.getRequestDispatcher("/listado.jsp");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }


}
