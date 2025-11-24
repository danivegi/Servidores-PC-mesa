package modelo;

public class Alumno {
    
    private String nombre, apellidos, dawes, dawec, diw, daw, fct, proyecto;

    public Alumno() {
        
    }

    public Alumno(String nombre, String apellidos, String dawes, String dawec, String diw, String daw, String fct, String proyecto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dawes = dawes;
        this.dawec = dawec;
        this.diw = diw;
        this.daw = daw;
        this.fct = fct;
        this.proyecto = proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDawes() {
        return dawes;
    }

    public void setDawes(String dawes) {
        this.dawes = dawes;
    }

    public String getDawec() {
        return dawec;
    }

    public void setDawec(String dawec) {
        this.dawec = dawec;
    }

    public String getDiw() {
        return diw;
    }

    public void setDiw(String diw) {
        this.diw = diw;
    }

    public String getDaw() {
        return daw;
    }

    public void setDaw(String daw) {
        this.daw = daw;
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dawes=" + dawes + ", dawec=" + dawec + ", diw=" + diw + ", daw=" + daw + ", fct=" + fct + ", proyecto=" + proyecto + '}';
    }
    
}
