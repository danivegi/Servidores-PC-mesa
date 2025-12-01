package modelo;

import java.time.LocalDate;

public class Comercial {

    private String codigo;
    private String nombre;
    private double salario;
    private int hijos;
    private LocalDate fNacimiento;

    public Comercial() {

    }

    public Comercial(String codigo, String nombre, double salario, int hijos, LocalDate fNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
        this.fNacimiento = fNacimiento;
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

}
