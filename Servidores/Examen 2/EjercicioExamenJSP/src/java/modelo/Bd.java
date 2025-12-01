package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

public class Bd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "business";

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

    public static ArrayList<Comercial> consultarComerciales() {
        ArrayList<Comercial> listaComerciales = new ArrayList<>();
        String sql = "SELECT * FROM comerciales";
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                int hijos = rs.getInt("hijos");
                Date fNacimiento = rs.getDate("fNacimiento");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
                String tiendaid = rs.getString("tiendaid");

                LocalDate fecha = fNacimiento.toLocalDate();
                Comercial c = new Comercial(codigo, nombre, salario, hijos, fecha, usuario, password, tiendaid);
                listaComerciales.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaComerciales;
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

    public static ArrayList<Tienda> consultarTiendas() {
        ArrayList<Tienda> listaTiendas = new ArrayList<>();
        String sql = "SELECT * FROM tienda";
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idtienda = rs.getString("idtienda");
                String nombre = rs.getString("nombre");
                String direcion = rs.getString("direcion");
                String poblacion = rs.getString("poblacion");

                Tienda t = new Tienda(idtienda, nombre, direcion, poblacion);
                listaTiendas.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTiendas;
    }

    public static ArrayList<TGrande> consultarTodasTiendas(String id) {
        ArrayList<TGrande> listaTG = new ArrayList<>();

        try (Connection cnn = CrearConexion()) {
            String sql = "SELECT v.fecha as fecha, c.nombre as comercial, p.nombre as producto, v.cantidad as cantidad, "
                    + "p.precio as precio, p.descuento as descuento "
                    + "FROM VENTAS v, COMERCIALES c, PRODUCTOS p, TIENDA t "
                    + "WHERE c.codigo = v.codComercial AND v.refProducto = p.referencia "
                    + "AND c.tiendaid = t.idtienda AND t.idtienda LIKE ?";

            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date fecha = rs.getDate("fecha");
                String comercial = rs.getString("comercial");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double total = cantidad * precio;
                int descuento = rs.getInt("descuento");
                double totalDto = total - (total * descuento * 0.01);
                
                LocalDate f = fecha.toLocalDate();
                TGrande tg = new TGrande(f, comercial, producto, cantidad, precio, total, descuento, totalDto);
                listaTG.add(tg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTG;
    }
    
    public static ArrayList<TGrande> consultarTiendaPorComercial(String codigo) {
        ArrayList<TGrande> listaTG = new ArrayList<>();

        try (Connection cnn = CrearConexion()) {
            String sql = "SELECT v.fecha as fecha, c.nombre as comercial, p.nombre as producto, v.cantidad as cantidad, "
                    + "p.precio as precio, p.descuento as descuento "
                    + "FROM VENTAS v, COMERCIALES c, PRODUCTOS p, TIENDA t "
                    + "WHERE c.codigo = v.codComercial AND v.refProducto = p.referencia "
                    + "AND c.tiendaid = t.idtienda AND c.codigo LIKE ?";

            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + codigo + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date fecha = rs.getDate("fecha");
                String comercial = rs.getString("comercial");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double total = cantidad * precio;
                int descuento = rs.getInt("descuento");
                double totalDto = total - (total * descuento * 0.01);
                
                LocalDate f = fecha.toLocalDate();
                TGrande tg = new TGrande(f, comercial, producto, cantidad, precio, total, descuento, totalDto);
                listaTG.add(tg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTG;
    }
    
    public static ArrayList<TGrande> consultarTiendaEntreFechas(LocalDate f1, LocalDate f2) {
        ArrayList<TGrande> listaTG = new ArrayList<>();

        try (Connection cnn = CrearConexion()) {
            String sql = "SELECT v.fecha as fecha, c.nombre as comercial, p.nombre as producto, v.cantidad as cantidad, "
                    + "p.precio as precio, p.descuento as descuento "
                    + "FROM VENTAS v, COMERCIALES c, PRODUCTOS p, TIENDA t "
                    + "WHERE c.codigo = v.codComercial AND v.refProducto = p.referencia "
                    + "AND c.tiendaid = t.idtienda AND v.fecha BETWEEN ? AND ?";

            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(f1));
            ps.setDate(2, java.sql.Date.valueOf(f2));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date fecha = rs.getDate("fecha");
                String comercial = rs.getString("comercial");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double total = cantidad * precio;
                int descuento = rs.getInt("descuento");
                double totalDto = total - (total * descuento * 0.01);
                
                LocalDate f = fecha.toLocalDate();
                TGrande tg = new TGrande(f, comercial, producto, cantidad, precio, total, descuento, totalDto);
                listaTG.add(tg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTG;
    }
    
    public static ArrayList<Vendedor> consultaVendedores() {
        ArrayList<Vendedor> lista = new ArrayList<>();
        try {
            
            String sql = "SELECT c.nombre as nombre, Count(v.codComercial) as total "
                    + "FROM ventas v, comerciales c "
                    + "WHERE v.codComercial = c.codigo "
                    + "GROUP BY c.nombre";
            
            Connection cnn = CrearConexion();
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                int total = rs.getInt("total");
                
                Vendedor v = new Vendedor(nombre, total);
                lista.add(v);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean nuevaVenta(Venta v) {
        ArrayList<Venta> listaVentas = new ArrayList<>();
        String sql = "INSERT INTO ventas (codComercial, refProducto, cantidad, fecha) VALUES (?,?,?,?)";

        try (Connection cnn = CrearConexion(); PreparedStatement ps = cnn.prepareStatement(sql)) {

            ps.setString(1, v.getCodComercial());
            ps.setString(2, v.getRefProducto());
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
    
    

}
