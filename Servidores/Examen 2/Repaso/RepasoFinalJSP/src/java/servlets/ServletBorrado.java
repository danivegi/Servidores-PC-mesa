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

public class ServletBorrado extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String[] borrados = request.getParameterValues("borrado");
        
        for (int x = 0; x < borrados.length; x++) {
            Bd.borrarVenta(borrados[x]);
            Bd.borrarProducto(borrados[x]);
        }
        
        rd = contexto.getRequestDispatcher("/baja-producto.jsp");
        rd.forward(request, response);
        
    }


}
