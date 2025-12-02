package modelo;

public class Editorial {

    private String idEditorial, nameEditorial;

    public Editorial() {

    }

    public Editorial(String idEditorial, String nameEditorial) {
        this.idEditorial = idEditorial;
        this.nameEditorial = nameEditorial;
    }

    public String getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNameEditorial() {
        return nameEditorial;
    }

    public void setNameEditorial(String nameEditorial) {
        this.nameEditorial = nameEditorial;
    }

}
