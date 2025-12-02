package modelo;

import java.time.LocalDate;

public class Autor {

    private String idAutor, nombre, apellido, aNacimiento;

    public Autor() {

    }

    public Autor(String idAutor, String nombre, String apellido, String aNacimiento) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.aNacimiento = aNacimiento;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getaNacimiento() {
        return aNacimiento;
    }

    public void setaNacimiento(String aNacimiento) {
        this.aNacimiento = aNacimiento;
    }



}
