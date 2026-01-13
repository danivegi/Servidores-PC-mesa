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
import modelo.Producto;

public class ServletProducto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String referencia = request.getParameter("referencia");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String descuento = request.getParameter("descuento");

        String errores = "";
        boolean esValido = true;

        if (!compruebaReferencia(referencia)) {
            errores += "Referencia, ";
            esValido = false;
        }

        if (!compruebaPrecio(precio)) {
            errores += "Precio, ";
            esValido = false;
        }

        if (!compruebaDescuento(descuento)) {
            errores += "Descuento, ";
            esValido = false;
        }

        if (esValido) {
            double pre = Double.parseDouble(precio);
            int dto = Integer.parseInt(descuento);

            Producto p = new Producto(referencia, nombre, descripcion, pre, dto);
            boolean add = Bd.nuevoProducto(p);
            if (add) {
                rd = contexto.getRequestDispatcher("/productos.jsp");
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

    private boolean compruebaReferencia(String referencia) {
        if (referencia.length() != 6) {
            return false;
        }

        for (int x = 0; x < referencia.length(); x++) {
            char c = referencia.charAt(x);
            if (x < 2 && Character.isDigit(c)) {
                return false;
            }
            if (x > 1 && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean compruebaPrecio(String precio) {
        if (precio.length() <= 0) {
            return false;
        }
        try {
            double pre = Double.parseDouble(precio);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean compruebaDescuento(String descuento) {
        if (descuento.length() <= 0) {
            return false;
        }

        for (int x = 0; x < descuento.length(); x++) {
            char c = descuento.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
