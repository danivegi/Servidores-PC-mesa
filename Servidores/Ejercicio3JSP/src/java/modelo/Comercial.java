package modelo;

import java.time.LocalDate;

public class Comercial {
    
    private String codigo, nombre;
    private double salario;
    private int hijos;
    LocalDate fNacimineto;

    public Comercial() {
        
    }

    public Comercial(String codigo, String nombre, double salario, int hijos, LocalDate fNacimineto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
        this.fNacimineto = fNacimineto;
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

    public LocalDate getfNacimineto() {
        return fNacimineto;
    }

    public void setfNacimineto(LocalDate fNacimineto) {
        this.fNacimineto = fNacimineto;
    }

    @Override
    public String toString() {
        return "Comercial{" + "codigo=" + codigo + ", nombre=" + nombre + ", salario=" + salario + ", hijos=" + hijos + ", fNacimineto=" + fNacimineto + '}';
    }
    
}
