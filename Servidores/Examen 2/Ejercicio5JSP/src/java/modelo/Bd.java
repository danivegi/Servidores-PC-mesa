package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;


public class Bd {
    
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "ciclodaw";

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
    
    public static ArrayList<Alumno> consultarAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM alumnos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listaAlumnos.clear();
            
            while(rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String dawes = rs.getString("DAWES");
                String dawec = rs.getString("DAWEC");
                String diw = rs.getString("DIW");
                String daw = rs.getString("DAW");
                String fct = rs.getString("FCT");
                String proyecto = rs.getString("Proyecto");
                Alumno nuevoAlumno = new Alumno(nombre, apellidos, dawes, dawec, diw, daw, fct, proyecto);
                listaAlumnos.add(nuevoAlumno);
            }
            
            if (cnn != null) {
                cnn.close();
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }
    
    public static boolean nuevoAlumno(Alumno a) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
        
        String sql = "INSERT INTO alumnos (Nombre, Apellidos, DAWES, DAWEC, DIW, DAW, FCT, Proyecto) VALUES (?,?,?,?,?,?,?,?);";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getDawes());
            ps.setString(4, a.getDawec());
            ps.setString(5, a.getDiw());
            ps.setString(6, a.getDaw());
            ps.setString(7, a.getFct());
            ps.setString(8, a.getProyecto());
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public static boolean modificarAlumno(Alumno a) {
        String sql = "UPDATE alumnos SET Apellidos = ?, DAWES = ?, DAWEC = ?, DIW = ?, DAW = ?, FCT = ?, Proyecto = ? WHERE Nombre = ?;";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            ps.setString(1, a.getApellidos());
            ps.setString(2, a.getDawes());
            ps.setString(3, a.getDawec());
            ps.setString(4, a.getDiw());
            ps.setString(5, a.getDaw());
            ps.setString(6, a.getFct());
            ps.setString(7, a.getProyecto());
            ps.setString(8, a.getNombre());
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
