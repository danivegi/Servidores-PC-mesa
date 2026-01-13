package modelo;

import java.sql.*;
import java.util.ArrayList;

public class Bd {
    
     public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "negocio";

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
    
    public static boolean nuevoProducto(Producto p) {
        String sql = "INSERT INTO productos (referencia, nombre, descripcion, precio, descuento) VALUES (?,?,?,?,?)";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            ps.setString(1, p.getReferencia());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getDescuento());
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        
        try {
            Connection cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String referencia = rs.getString("referencia");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int descuento = rs.getInt("descuento");
                
                Producto p = new Producto(referencia, nombre, descripcion, precio, descuento);
                listaProductos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    public static void borrarVenta(String ref) {
        String sql = "DELETE FROM ventas WHERE refProducto = ?";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            ps.setString(1, ref);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void borrarProducto(String ref) {
        String sql = "DELETE FROM productos WHERE referencia = ?";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            ps.setString(1, ref);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
