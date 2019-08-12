package enviosPostales;

import java.util.ArrayList;

public class AsignadorDeVehiculos {


    public String asignar(ArrayList<Integer> pesos) {
        int peso = pesos.stream().reduce(0, Integer::sum);
        if (peso <= 0)
            return null;
        if (peso <= 5)
            return "Bicicleta";
        else if (peso <= 50)
            return "Auto";
        else if (peso <= 150)
            return "Camioneta";
        else
            return null;
    }
}
