package modelo;

import java.sql.*;
import java.util.ArrayList;

public class Bd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "telepizza";

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
    
    public static ArrayList<Pizza> consultarPizzas (String idPizza) {
        ArrayList<Pizza> listaPizzas = new ArrayList<Pizza>();
        
        try {
            String sql = "SELECT * FROM pizzas WHERE idpizza = ?";
            Connection cnn = CrearConexion();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            int idP = Integer.parseInt(idPizza);
            ps.setInt(1, idP);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nompizzas");
                int idPizz = rs.getInt("idpizza");
                double precio = rs.getDouble("precio");
                
                Pizza p = new Pizza(id, nombre, idPizz, precio);
                listaPizzas.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPizzas;
    }
    
    public static double consultarPrecio(String nombre) {
        double precio = 0;
        try {
            String sql = "SELECT precio FROM pizzas WHERE nompizzas = ?";
            Connection cnn = CrearConexion();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return precio;
    }

}
