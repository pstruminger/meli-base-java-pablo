package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Hablador> habladores = new ArrayList<>();

        habladores.add(new Persona());
        habladores.add(new Perro());
        habladores.add(() -> "Soy un marcianito");


    }


}
