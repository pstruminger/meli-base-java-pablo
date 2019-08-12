package enviosPostales;

import java.util.ArrayList;

public class Despachante {

    private static Despachante unico = null;
    private CalculadorDeCostos calculadorDeCostos;
    private AsignadorDeVehiculos asignadorDeVehiculos;

    private Despachante() {
    }

    public static Despachante getInstance() {
        if (unico == null) {
            unico = new Despachante();
        }
        return unico;
    }


    public Envio generarEnvio(ArrayList<Integer> pesosDePaquetes, String direccion) {
        if (pesosDePaquetes == null || pesosDePaquetes.isEmpty())
            return null;

        int costo = calculadorDeCostos.calcular(pesosDePaquetes);
        String vehiculo = asignadorDeVehiculos.asignar(pesosDePaquetes);

        if (costo != 0 && vehiculo != null)
            return Envio.getInstance(pesosDePaquetes, direccion, costo, vehiculo);
        return null;
    }

    public CalculadorDeCostos getCalculadorDeCostos() {
        return calculadorDeCostos;
    }

    public AsignadorDeVehiculos getAsignadorDeVehiculos() {
        return asignadorDeVehiculos;
    }

    public void setCalculadorDeCostos(CalculadorDeCostos calculadorDeCostos) {
        this.calculadorDeCostos = calculadorDeCostos;
    }

    public void setAsignadorDeVehiculos(AsignadorDeVehiculos asignadorDeVehiculos) {
        this.asignadorDeVehiculos = asignadorDeVehiculos;
    }
}
