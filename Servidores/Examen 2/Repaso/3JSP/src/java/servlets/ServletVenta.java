package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bd;
import modelo.Venta;

public class ServletVenta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String comercial = request.getParameter("comercial");
        String producto = request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");

        String errores = "";
        boolean esValido = true;

        if (!compruebaComercial(comercial)) {
            errores += "Comercial ";
            esValido = false;
        }

        if (!compruebaProducto(producto)) {
            errores += " Producto ";
            esValido = false;
        }

        if (!compruebaCantidad(cantidad)) {
            errores += " Cantidad ";
            esValido = false;
        }

        if (!compruebaFecha(fecha)) {
            errores += " Fecha ";
            esValido = false;
        }

        if (esValido) {
            LocalDate f = LocalDate.parse(fecha);
            int cant = Integer.parseInt(cantidad);

            Venta v = new Venta(f, comercial, producto, cant);
            boolean add = Bd.nuevaVenta(v);

            if (add) {
                rd = contexto.getRequestDispatcher("/listado-ventas.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("/errores.jsp");
                rd.forward(request, response);
            }
        } else {
            contexto.setAttribute("errores", errores);
            rd = contexto.getRequestDispatcher("/errores.jsp");
            rd.forward(request, response);
        }

    }

    private boolean compruebaComercial(String comercial) {
        if (comercial.equals("0")) {
            return false;
        }
        return true;
    }

    private boolean compruebaProducto(String producto) {
        if (producto.equals("0")) {
            return false;
        }
        return true;
    }

    private boolean compruebaCantidad(String cantidad) {
        if (cantidad.length() <= 0) {
            return false;
        }

        for (int x = 0; x < cantidad.length(); x++) {
            char c = cantidad.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean compruebaFecha(String fecha) {
        if (fecha.length() <= 0) {
            return false;
        }

        try {
            LocalDate f = LocalDate.parse(fecha);
            if (f.isAfter(LocalDate.now())) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
