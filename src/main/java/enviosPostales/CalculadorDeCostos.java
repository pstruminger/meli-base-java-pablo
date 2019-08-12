package enviosPostales;

import java.util.List;

public class CalculadorDeCostos {

    public int calcular(List<Integer> paquetes) {
        if (paquetes == null)
            return 0;
        int cantidadDePaquetes = paquetes.size();
        if (cantidadDePaquetes > 0) {
            if (cantidadDePaquetes < 5)
                return 45;
            else if (cantidadDePaquetes < 10)
                return 72;
            else {
                int costoAdicional = (cantidadDePaquetes - 9) * 15;
                return 72 + costoAdicional;
            }
        }
        return 0;
    }

}
