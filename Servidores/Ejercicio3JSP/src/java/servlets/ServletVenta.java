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

        String comercial = request.getParameter("com");
        String producto = request.getParameter("prod");
        String cantidad = request.getParameter("cantidad");
        String fechaVenta = request.getParameter("fechaVenta");

        String error = "";
        boolean esValido = true;

        if (!comprobarComercial(comercial)) {
            error += "Error en el campo Comercial";
            esValido = false;
        }

        if (!comprobarProducto(producto)) {
            error += "Error en el campo Producto";
            esValido = false;
        }

        if (!comprobarCantidad(cantidad)) {
            error += "Error en el campo Cantidad";
            esValido = false;
        }

        if (!comprobarFecha(fechaVenta)) {
            error += "Error en el campo Fecha";
            esValido = false;
        }

        if (esValido) {
            LocalDate fecha = LocalDate.parse(fechaVenta);
            int cant = Integer.parseInt(cantidad);

            Venta v = new Venta(fecha, comercial, producto, cant);

            boolean add = Bd.nuevaVenta(v);
            if (add) {
                rd = contexto.getRequestDispatcher("/nuevaVenta.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", error);
                rd = contexto.getRequestDispatcher("/errorAlta.jsp");
                rd.forward(request, response);
            }
        } else {
            contexto.setAttribute("errores", error);
            rd = contexto.getRequestDispatcher("/errorAlta.jsp");
            rd.forward(request, response);
        }

    }

    public boolean comprobarComercial(String comercial) {
        if (comercial == "0") {
            return false;
        }

        return true;
    }

    public boolean comprobarProducto(String producto) {
        if (producto == "0") {
            return false;
        }

        return true;
    }

    public boolean comprobarCantidad(String cantidad) {
        for (int x = 0; x < cantidad.length(); x++) {
            char c = cantidad.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int cant = Integer.parseInt(cantidad);
        if (cant == 0) {
            return false;
        }
        return true;
    }

    public boolean comprobarFecha(String fechaVenta) {
        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(fechaVenta);

            if (fecha.isAfter(LocalDate.now())) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
