package tragamonedas;

import java.util.Random;

public class Tambor {

    private int posicion = 0;

    public int obtenerPosicion() {
        return posicion;
    }

    public void girar() {
        Random random = new Random();

        posicion = random.nextInt(8) + 1;
    }

}
