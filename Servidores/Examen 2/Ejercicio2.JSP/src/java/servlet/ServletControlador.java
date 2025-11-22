package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recojo el parámetro y compruebo que no está vacío
        String titulo_a_buscar = request.getParameter("titulo").trim();
        int tamano = titulo_a_buscar.length();
        
        // Si la cadena esta vacía muestro un error sino ejecuto la consulta
        if (tamano < 1) {
            request.getRequestDispatcher("/error1.html").forward(request, response);
        } else {
            request.getRequestDispatcher("/rtdo.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
