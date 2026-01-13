package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletTelefono extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        long fecha;
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        fecha = sesion.getLastAccessedTime();
        Date fechaC = new Date(fecha);
        SimpleDateFormat formatofecha = new SimpleDateFormat("kk:mm:ss dd/MM/yyyy");
        
        String fec = formatofecha.format(fechaC);
        contexto.setAttribute("fechaPedido", fec);
        
        String telefono = request.getParameter("telefono");
        
        if (telefono.equals("123456789")) {
            rd = contexto.getRequestDispatcher("/confirmar.jsp");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/errorTel.html");
            rd.forward(request, response);
        }
    }

}
