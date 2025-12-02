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
import modelo.Titulo;

public class ServletLibro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String editorial = request.getParameter("editorial");
        String year = request.getParameter("year");
        String descripcion = request.getParameter("desc");

        String errores = "";
        boolean esValido = true;

        if (!compruebaIsbn(isbn)) {
            errores += "Isbn, ";
            esValido = false;
        }

        if (!compruebaTitulo(titulo)) {
            errores += "Titulo, ";
            esValido = false;
        }

        if (!compruebaYear(year)) {
            errores += "Año de edición, ";
            esValido = false;
        }

        if (!compruebaDesc(descripcion)) {
            errores += "Descripción, ";
            esValido = false;
        }

        if (esValido) {
            int idEd = Integer.parseInt(editorial);

            Titulo t = new Titulo(isbn, titulo, autor, year, descripcion, idEd);
            boolean add = Bd.nuevoTitulo(t);
            if (add) {
                rd = contexto.getRequestDispatcher("/listado-libros.jsp");
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

    private boolean compruebaIsbn(String isbn) {
        if (isbn.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaTitulo(String titulo) {
        if (titulo.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean compruebaYear(String year) {
        if (year.length() != 4) {
            return false;
        }
        try {
            int y = Integer.parseInt(year);
            if (y < 2000 || y > 2022) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean compruebaDesc(String descripcion) {
        if (descripcion.length() <= 0) {
            return false;
        }
        return true;
    }

}
