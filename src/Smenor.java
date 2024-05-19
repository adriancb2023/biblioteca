public class Smenor extends Socio{
    private String Tutor;
    private int num_socio_tutor;
    public Smenor(String nombre, int num_socio) {
        super(nombre, num_socio);
        Tutor = nombre;
        num_socio_tutor = num_socio;
    }

    //getter

    public String getTutor() {
        return Tutor;
    }

    public int getNum_Socio_Tutor() {
        return num_socio_tutor;
    }

    //setter

    //otros metodos

    @Override
    public String mostrar_info() {
        return super.mostrar_info() + "Tutor: " + Tutor + "Número de socio del tutor: " + num_socio_tutor;
    }

}
