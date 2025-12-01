package modelo;

import java.time.LocalDate;

public class TGrande {

    private LocalDate fecha;
    private String comercial;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;
    private int descuento;
    private double totalDto;

    public TGrande() {

    }

    public TGrande(LocalDate fecha, String comercial, String producto, int cantidad, double precio, double total, int descuento, double totalDto) {
        this.fecha = fecha;
        this.comercial = comercial;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.descuento = descuento;
        this.totalDto = totalDto;
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

    public double getTotalDto() {
        return totalDto;
    }

    public void setTotalDto(double totalDto) {
        this.totalDto = totalDto;
    }

}
