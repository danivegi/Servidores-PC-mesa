package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
        
        String nombre = request.getParameter("nombre");
        String cif = request.getParameter("cif");
        String representante = request.getParameter("representante");
        String nif = request.getParameter("nif");
        String sector = request.getParameter("sector");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String ventas = request.getParameter("ventas");
        String observaciones = request.getParameter("observaciones");
        
        boolean esValido = true;
        String error = "";
        
        if (esValido) {
            Cliente nuevoCliente = new Cliente(nombre, cif, representante, nif, sector, telefono, email, ventas, observaciones);
            List<Cliente> lista = (List<Cliente>) contexto.getAttribute("lista");
            lista.add(nuevoCliente);
            rd = contexto.getRequestDispatcher("/Formulario.jsp");
            rd.forward(request, response);
        } else {
            contexto.setAttribute("errores", error);
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

}
