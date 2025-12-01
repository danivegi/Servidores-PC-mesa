package modelo;

import java.time.LocalDate;

public class Comercial {
    
    private String codigo, nombre;
    private double salario;
    private int hijos;
    private LocalDate fNacimiento;
    private String usuario, password, tiendaid;

    public Comercial() {
        
    }

    public Comercial(String codigo, String nombre, double salario, int hijos, LocalDate fNacimiento, String tiendaid) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
        this.fNacimiento = fNacimiento;
        this.tiendaid = tiendaid;
    }

    public Comercial(String codigo, String nombre, double salario, int hijos, LocalDate fNacimiento, String usuario, String password, String tiendaid) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
        this.fNacimiento = fNacimiento;
        this.usuario = usuario;
        this.password = password;
        this.tiendaid = tiendaid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTiendaid() {
        return tiendaid;
    }

    public void setTiendaid(String tiendaid) {
        this.tiendaid = tiendaid;
    }
    
}
