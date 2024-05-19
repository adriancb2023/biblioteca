public class Smayor extends Socio{
    private String dni;
    private String telf;

    public Smayor(String nombre, int  num_socio, String dni, String telf) {
        super(nombre, num_socio);
        this.dni = dni;
        this.telf = telf;
    }

    //getter
    public String getDni() {
        return dni;
    }

    public String getTelf() {
        return telf;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public int getNum_Socio() {
        return super.getNum_Socio();
    }

    //setter

    private void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }
    @Override
    public String mostrar_info() {
        return super.mostrar_info();
    }
}
