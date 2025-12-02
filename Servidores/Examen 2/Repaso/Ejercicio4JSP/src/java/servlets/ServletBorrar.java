package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bd;

public class ServletBorrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String titulo = request.getParameter("titulo");
        
        boolean add = Bd.borrarLibro(titulo);
        
        if (add) {
            rd = contexto.getRequestDispatcher("/listado-libros.jsp");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
    }

}
