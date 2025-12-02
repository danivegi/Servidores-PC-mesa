package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "examen";

    public static Connection CrearConexion() {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url, usuario, password); //nos conectamos a la BD
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado" + c.toString());
        } catch (Exception c) {
            System.out.println("Otrа ехсерción" + c.toString());
        }
        return cnn;
    }

    public static ArrayList<Libro> consultarLibros(String tit) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sql = "SELECT T.Titulo as titulo, T.ISBN as isbn, (CONCAT(A.Nombre, ', ', A.Apellido)) as autor, E.NameEditorial as editorial, T.Descripcion as descripcion "
                    + "FROM titulos T, editorial E, autor A "
                    + "WHERE E.IDeditorial = T.idEditorial "
                    + "AND T.idAutor = A.IDAutor "
                    + "AND T.titulo LIKE ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + tit + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String isbn = rs.getString("isbn");
                String autor = rs.getString("autor");
                String editorial = rs.getString("editorial");
                String descripcion = rs.getString("descripcion");

                Libro l = new Libro(titulo, isbn, autor, editorial, descripcion);
                listaLibros.add(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaLibros;
    }

    public static ArrayList<Autor> consultarAutores() {
        ArrayList<Autor> listaAutores = new ArrayList<>();

        try {

            String sql = "SELECT * FROM autor";
            Connection cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idAutor = rs.getString("IDAutor");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String aNacimiento = rs.getString("anioNacimiento");

                Autor a = new Autor(idAutor, nombre, apellido, aNacimiento);
                listaAutores.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAutores;
    }

    public static ArrayList<Editorial> consultarEditoriales() {
        ArrayList<Editorial> listaEditoriales = new ArrayList<>();

        try {

            String sql = "SELECT * FROM editorial";
            Connection cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idEditorial = rs.getString("IDEditorial");
                String nombre = rs.getString("NameEditorial");

                Editorial ed = new Editorial(idEditorial, nombre);
                listaEditoriales.add(ed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEditoriales;
    }

    public static ArrayList<Titulo> consultarTitulos() {
        ArrayList<Titulo> listaTitulos = new ArrayList<>();

        try {

            String sql = "SELECT * FROM titulos";
            Connection cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String titulo = rs.getString("titulo");
                String idAutor = rs.getString("idAutor");
                String anioEdicion = rs.getString("anioEdicion");
                String descripcion = rs.getString("descripcion");
                int idEditorial = rs.getInt("idEditorial");

                Titulo t = new Titulo(isbn, titulo, idAutor, anioEdicion, descripcion, idEditorial);
                listaTitulos.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTitulos;
    }

    public static boolean nuevoTitulo(Titulo t) {
        String sql = "INSERT INTO titulos (ISBN, Titulo, IDautor, AnioEdicion, Descripcion, IDeditorial) VALUES (?,?,?,?,?,?)";

        try (Connection cnn = CrearConexion(); PreparedStatement ps = cnn.prepareStatement(sql)) {
            ps.setString(1, t.getIsbn());
            ps.setString(2, t.getTitulo());
            ps.setString(3, t.getIdAutor());
            ps.setString(4, t.getaEdicion());
            ps.setString(5, t.getDescripcion());
            ps.setInt(6, t.getIdEditorial());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean borrarLibro(String tit) {
        String sql = "DELETE FROM titulos WHERE Titulo = ?";

        try (Connection cnn = CrearConexion(); PreparedStatement ps = cnn.prepareStatement(sql)) {
            ps.setString(1, tit);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
