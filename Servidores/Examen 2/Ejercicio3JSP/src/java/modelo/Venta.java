package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Venta {
    
    LocalDate fecha;
    String comercial,producto;
    int cantidad,descuento;
    double precio,total,totaldescuento;
    

    public Venta() {
        
    }

    public Venta(LocalDate fecha, String comercial, String producto, int cantidad) {
        this.fecha = fecha;
        this.comercial = comercial;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Venta(LocalDate fecha, String comercial, String producto, int cantidad, int descuento, double precio, double total, double totaldescuento) {
        this.fecha = fecha;
        this.comercial = comercial;
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
        this.total = total;
        this.totaldescuento = totaldescuento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getTotaldescuento() {
        return totaldescuento;
    }

    public void setTotaldescuento(double totaldescuento) {
        this.totaldescuento = totaldescuento;
    }
    
}