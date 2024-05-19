public class Revista extends Publicaciones {
    private int num_public;
    private String editorial;

    public Revista(String titulo, int ano, boolean disponibilidad, int num_public, String editorial) {
        super(titulo, ano, disponibilidad);
        this.num_public = num_public;
        this.editorial = editorial;
    }

    //getter

    public int getNum_public() {
        return num_public;
    }

    public String getEditorial() {
        return editorial;
    }

    //setter

    public void setNum_public(int num_public) {
        this.num_public = num_public;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()+ "Número de publicaciones: " + num_public+ "Editorial: " + editorial;
    }
}