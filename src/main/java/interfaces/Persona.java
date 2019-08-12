package interfaces;

public class Persona implements Hablador {

    private String nombre;

    @Override
    public String hablar() {
        return "blablabla";
    }

}
