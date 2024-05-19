public class Manual extends Publicaciones {
    private String idioma;
    private String tema;

    public Manual(String titulo, int ano, boolean disponibilidad, String idioma , String tema) {
        super(titulo, ano, disponibilidad);
        this.idioma = idioma;
        this.tema = tema;
    }

    //getter
    public String getIdioma() {
        return idioma;
    }

    public String getTema() {
        return tema;
    }

    //setter
    public void setIdioma(String idioma) {  this.idioma=idioma; }

    public void setTema(String tema) {  this.tema=tema; }

    @Override
    public String mostrarInfo(){
        return super.mostrarInfo() + " Idioma: " + idioma + " Tema " + tema;
    }
}
