import java.awt.*;

abstract class Publicaciones {
    private String titulo;
    private int ano;
    private boolean disponibilidad;

    public Publicaciones(String titulo, int ano, boolean disponibilidad) {
        this.titulo = titulo;
        this.ano = ano;
        this.disponibilidad = disponibilidad;
    }

    //getter
    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    //setter

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    //otros metodos

    public String prestado() {
        if (disponibilidad){
            return "Prestado";
        }else {
            return "Disponible";
        }
    }

    public String mostrarInfo() {
        return "Título: " + titulo+ " Año: " + ano + " Disponibilidad: " + disponibilidad;
    }
}