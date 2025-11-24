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

public class ServletModProducto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String referencia = request.getParameter("ref");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("desc");
        String precio = request.getParameter("precio");
        String descuento = request.getParameter("dto");

        String errores = "";
        boolean esValido = true;
        
        if (!compruebaRef(referencia)) {
            errores += " Referencia ";
            esValido = false;
        }

        if (!compruebaNombre(nombre)) {
            errores += " Nombre ";
            esValido = false;
        }

        if (!compruebaDesc(descripcion)) {
            errores += " Descripción ";
            esValido = false;
        }

        if (!compruebaPrecio(precio)) {
            errores += " Precio ";
            esValido = false;
        }

        if (!compruebaDto(descuento)) {
            errores += " Descuento ";
            esValido = false;
        }

        if (esValido) {
            double precioNumb = Double.parseDouble(precio);
            int dto = Integer.parseInt(descuento);
            Producto p = new Producto(referencia, nombre, descripcion, precioNumb, dto);
            boolean add = Bd.modificarProducto(p);

            if (add) {
                rd = contexto.getRequestDispatcher("/listado-productos.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("/errorAlta.jsp");
                rd.forward(request, response);
            }
        } else {
            contexto.setAttribute("errores", errores);
            rd = contexto.getRequestDispatcher("/errorAlta.jsp");
            rd.forward(request, response);
        }

    }
    
    private boolean compruebaRef(String referencia) {
        if (referencia.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaNombre(String nombre) {
        if (nombre.length() <= 0) {
            return false;
        }
        for (int x = 0; x < nombre.length(); x++) {
            char c = nombre.charAt(x);
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean compruebaDesc(String descripcion) {
        if (descripcion.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaPrecio(String precio) {
        if (precio.length() <= 0) {
            return false;
        }
        try {
            double precioNumb = Double.parseDouble(precio);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean compruebaDto(String dto) {
        if (dto.length() <= 0) {
            return false;
        }
        try {
            int descuento = Integer.parseInt(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
