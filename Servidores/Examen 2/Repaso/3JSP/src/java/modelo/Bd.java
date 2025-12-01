package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

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
        String sql = "SELECT * FROM productos";
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String ref = rs.getString("referencia");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int descuento = rs.getInt("descuento");
                
                Producto p = new Producto(ref, nombre, descripcion, precio, descuento);
                listaProductos.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    public static ArrayList<Venta> consultarVentas(String ref) {
        ArrayList<Venta> listadoVentas = new ArrayList<>();
        String sql = "SELECT v.fecha as fecha, c.nombre as comercial, p.nombre as producto, v.cantidad as cantidad, p.precio as precio, p.descuento as descuento "
                + "FROM ventas v, comerciales c, productos p "
                + "WHERE c.codigo = v.codComercial "
                + "AND v.refProducto = p.referencia "
                + "AND p.referencia LIKE ?";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)){
            
            ps.setString(1, "%" + ref + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Date fecha = rs.getDate("fecha");
                LocalDate f = fecha.toLocalDate();
                String comercial = rs.getString("comercial");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double total = cantidad * precio;
                int descuento = rs.getInt("descuento");
                double totalDto = total - (total * descuento * 0.01);
                
                Venta v = new Venta(f, comercial, producto, cantidad, precio, total, descuento, totalDto);
                        listadoVentas.add(v);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listadoVentas;
    }
    
    public static ArrayList<Comercial> consultarComerciales() {
        ArrayList<Comercial> listaComerciales = new ArrayList<>();
        
        String sql = "SELECT * FROM comerciales";
        
        try {
            Connection cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                int hijos = rs.getInt("hijos");
                Date fecha = rs.getDate("fNacimiento");
                LocalDate f = fecha.toLocalDate();
                
                Comercial c = new Comercial(codigo, nombre, salario, hijos, f);
                listaComerciales.add(c);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaComerciales;
    }
    
    public static boolean nuevaVenta(Venta v) {
        ArrayList<Venta> listaVentas = new ArrayList<>();
        String sql = "INSERT INTO ventas (codComercial, refProducto, cantidad, fecha) VALUES (?,?,?,?)";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, v.getComercial());
            ps.setString(2, v.getProducto());
            ps.setInt(3, v.getCantidad());
            ps.setDate(4, java.sql.Date.valueOf(v.getFecha()));
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean nuevoProducto(Producto p) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
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
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean modificarProducto(Producto p) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, descuento = ? WHERE referencia = ?";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getDescuento());
            ps.setString(5, p.getReferencia());
            
            ps.executeUpdate();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean nuevoComercial(Comercial c) {
        ArrayList<Comercial> listaComerciales = new ArrayList<>();
        String sql = "INSERT INTO comerciales (codigo, nombre, salario, hijos, fNacimiento) VALUES (?,?,?,?,?)";
        
        try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setDouble(3, c.getSalario());
            ps.setInt(4, c.getHijos());
            ps.setDate(5, Date.valueOf(c.getfNacimiento()));
            
            ps.executeUpdate();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}