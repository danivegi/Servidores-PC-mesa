package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Bd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "ventas_comerciales";

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

    public static ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sentenciaSQL = "SELECT * FROM productos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);
            listaProductos.clear();
            while (rs.next()) {
                String ref = rs.getString("referencia");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int descuento = rs.getInt("descuento");
                Producto nuevoProducto = new Producto(ref, nombre, descripcion, precio, descuento);
                listaProductos.add(nuevoProducto);
            }
            //Cerramos la cnexion
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public static ArrayList<Venta> consultarVentas(String ref) {
        ArrayList<Venta> listaVentas = new ArrayList<>();

        try (Connection cnn = CrearConexion()) {

            String sentenciaSQL
                    = "SELECT c.nombre AS comercial, p.nombre AS producto, v.cantidad AS cantidad, p.precio AS precio, "
                    + "       p.descuento AS descuento, v.fecha AS fecha "
                    + "FROM ventas v "
                    + "JOIN productos p ON v.refProducto = p.referencia "
                    + "JOIN comerciales c ON v.codComercial = c.codigo "
                    + "WHERE p.referencia LIKE ?";

            PreparedStatement ps = cnn.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + ref + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String comercial = rs.getString("comercial");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double total = cantidad * precio;
                int descuento = rs.getInt("descuento");
                double totalDescuento = total - (total * descuento / 100);
                Date fecha = rs.getDate("fecha");

                LocalDate fecha1 = fecha.toLocalDate();

                Venta v = new Venta(fecha1, comercial, producto, cantidad,
                        descuento, precio, total, totalDescuento);
                listaVentas.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaVentas;
    }

    public static ArrayList<Comercial> consultarComerciales() {
        ArrayList<Comercial> listaComerciales = new ArrayList<>();
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sentenciaSQL = "SELECT * FROM comerciales;";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);
            listaComerciales.clear();

            while (rs.next()) {
                String cod = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double salario = rs.getDouble("salario");
                int hijos = rs.getInt("hijos");
                Date fNacimiento = rs.getDate("fNacimiento");
                LocalDate fecha1 = fNacimiento.toLocalDate();

                Comercial nuevocomercial = new Comercial(cod, nombre, salario, hijos, fecha1);
                listaComerciales.add(nuevocomercial);
            }
            if (cnn != null) {
                cnn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaComerciales;

    }
    
    public static boolean nuevaVenta(Venta v) {
        
        ArrayList<Venta> listaVentas = new ArrayList<>();
        
        String sentenciaSQL = "INSERT INTO ventas (codComercial, refProducto, cantidad, fecha) VALUES (?,?,?,?);";
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sentenciaSQL)) {
            
            ps.setString(1, v.getComercial());
            ps.setString(2, v.getProducto());
            ps.setInt(3, v.getCantidad());
            ps.setDate(4, java.sql.Date.valueOf(v.getFecha()));
            
            ps.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.getLocalizedMessage();
            return false;
        }
    }
    
    public static boolean nuevoProducto(Producto p) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sentenciaSQL = "INSERT INTO productos (referencia, nombre, descripcion, precio, descuento) VALUES (?,?,?,?,?);";
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sentenciaSQL)) {
            
            ps.setString(1, p.getRef());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getDto());
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean nuevoComercial(Comercial c) {
        ArrayList<Comercial> listaComerciales = new ArrayList<Comercial>();
        
        String sql = "INSERT INTO comerciales (codigo, nombre, salario, hijos, fNacimiento) VALUES (?,?,?,?,?);";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setDouble(3, c.getSalario());
            ps.setInt(4, c.getHijos());
            ps.setDate(5, java.sql.Date.valueOf(c.getfNacimineto()));
            
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean modificarProducto(Producto p) {
        
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, descuento = ? WHERE referencia LIKE ?;";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getDto());
            ps.setString(5, p.getRef());
            
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
