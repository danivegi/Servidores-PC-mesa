package md;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Bd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "books";

    public static Connection CrearConexion() {
        Connection cnn = null;
        try{ 
            Class.forName("com.mysql.jdbc.Driver"); //invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url,usuario,password); //nos conectamos a la BD
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado" + c.toString());
        } catch (Exception c) {
            System.out.println("Otrа ехсерción" + c.toString());
        }
        return cnn;
    }
    
    public static ArrayList<Libro> consultaTitulos(String dato) {
        
        ArrayList<Libro> lista = new ArrayList<Libro>();
        Libro ebook;
        Connection cnn = null;
        try{ 
            cnn = CrearConexion();
            String sentenciaSQLPrecon = "SELECT titulos.Titulo, titulos.ISBN, autor.Nombre, editorial.NameEditorial, titulos.Descripcion FROM titulos, autor, editorial WHERE (titulos.IDautor=autor.IDautor) AND (titulos.IDeditorial = editorial.IDEditorial) AND (titulos.titulo like ?)";
            PreparedStatement smt = cnn.prepareStatement(sentenciaSQLPrecon);
            smt.setString(1,"%" + dato + "%");
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
            ebook = new Libro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            lista.add(ebook);
            } 
        } catch (SQLException e) {
            System.out.println("Controlador JDBC no encontrado" + e.toString());
        } catch (Exception e) {
                        System.out.println("Otra excepcion" + e.toString());
        }
        return lista;
    }
}
