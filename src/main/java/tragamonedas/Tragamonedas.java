package tragamonedas;

import java.util.ArrayList;
import java.util.List;

public class Tragamonedas {

    private List<Tambor> tambores;

    public Tragamonedas(Tambor tambor1, Tambor tambor2, Tambor tambor3) {
        tambores = new ArrayList<>();
        tambores.add(tambor1);
        tambores.add(tambor2);
        tambores.add(tambor3);
    }

    public int[] verPosicionesDeTambores() {
        return tambores.stream().mapToInt(Tambor::obtenerPosicion).toArray();
    }

    public void activar() {
        tambores.forEach(Tambor::girar);
    }

    public boolean entregaPremio() {
        return tambores.get(0).obtenerPosicion() == tambores.get(1).obtenerPosicion() &&
                tambores.get(1).obtenerPosicion() == tambores.get(2).obtenerPosicion();
    }

}
