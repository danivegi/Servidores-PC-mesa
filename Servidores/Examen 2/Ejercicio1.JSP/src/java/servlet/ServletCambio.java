/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletCambio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String importe = request.getParameter("importe");
        String entregado = request.getParameter("entregado");
        
        boolean esValido = true;
        String error = "";
        
        if (!compruebaImporte(importe)) {
            esValido = false;
            error += " Importe ";
        }
        
        if (!compruebaEntregado(entregado)) {
            esValido = false;
            error += " Entregado ";
        }
        
        if (esValido) {
            rd = contexto.getRequestDispatcher("/resultado.jsp");
            rd.forward(request, response);
        } else {
            contexto.setAttribute("errores", error);
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
    
    private boolean compruebaImporte(String importe) {
        if (importe.length() <= 0) {
            return false;
        }
        for (int x = 0; x < importe.length(); x++) {
            char c = importe.charAt(x);
            if (!Character.isDigit(c) && c != ',' && c != '.') {
                return false;
            }
        }
        return true;
    }
    
    private boolean compruebaEntregado(String entregado) {
        if (entregado.length() <= 0) {
            return false;
        }
        for (int x = 0; x < entregado.length(); x++) {
            char c = entregado.charAt(x);
            if (!Character.isDigit(c) && c != ',' && c != '.') {
                return false;
            }
        }
        return true;
    }

}
