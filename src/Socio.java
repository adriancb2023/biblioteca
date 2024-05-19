abstract class Socio {
    private String nombre;
    private int num_socio;

    public Socio(String nombre, int num_socio) {
        this.nombre = nombre;
        this.num_socio = num_socio;
    }

    //getter
    public String getNombre() {
        return nombre;
    }

    public int getNum_Socio(){
        return num_socio;
    };

    //setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setDni(int num_socio) {
        this.num_socio = num_socio;
    }

    public String mostrar_info() {
        return "Socio{" +
                "nombre='" + nombre + '\'' +
                ", num_socio=" + num_socio +
                '}';
    }
}