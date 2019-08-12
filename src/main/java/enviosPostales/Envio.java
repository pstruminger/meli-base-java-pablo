package enviosPostales;

import java.util.ArrayList;

public class Envio {

    private ArrayList<Integer> pesos;
    private String direccion;
    private int costo;
    private String transporte;

    public static Envio getInstance(ArrayList<Integer> pesos, String direccion, int costo, String transporte) {
        if (pesos == null || pesos.stream().reduce(0, Integer::sum) > 150 || pesos.stream().reduce(0, Integer::sum) <= 0)
            return null;
        return new Envio(pesos, direccion, costo, transporte);
    }

    private Envio(ArrayList<Integer> pesos, String direccion, int costo, String transporte) {
        this.pesos = pesos;
        this.direccion = direccion;
        this.costo = costo;
        this.transporte = transporte;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCosto() {
        return costo;
    }

    public String getTransporte() {
        return transporte;
    }
}
