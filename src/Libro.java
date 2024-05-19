public class Libro extends Publicaciones {

    private String isbn;

    private String categoria;

    public Libro(String titulo, int ano, boolean disponibilidad, String isbn, String categoria) {
        super(titulo, ano, disponibilidad);
        this.isbn = isbn;
        this.categoria = categoria;
    }

    //getter
    public String getIsbn() {
        return isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    //setter

    private void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()+" ISBN: " + isbn+ " Categoría: " + categoria;
    }

}