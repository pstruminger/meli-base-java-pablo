package enviosPostales;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EnviosPostalesTest {

    @Test
    public void unCalculadorDeCostosPuedeCrearse() {
        CalculadorDeCostos calculador = new CalculadorDeCostos();

        Assertions.assertThat(calculador).isNotNull();
    }

    @Test
    public void unCalculadorDeCostosCalculaCorrectamenteElCostoDeUnEnvioDe5PaquetesOMenos() {
        CalculadorDeCostos calculador = new CalculadorDeCostos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(1);
        pesos.add(2);
        pesos.add(3);
        pesos.add(4);

        Assertions.assertThat(calculador.calcular(pesos)).isEqualTo(45);
    }

    @Test
    public void unCalculadorDeCostosCalculaCorrectamenteElCostoDeUnEnvioDeMasDe5YMenosDe10Paquetes() {
        CalculadorDeCostos calculador = new CalculadorDeCostos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(1);
        pesos.add(2);
        pesos.add(3);
        pesos.add(4);
        pesos.add(5);
        pesos.add(6);

        Assertions.assertThat(calculador.calcular(pesos)).isEqualTo(72);
    }

    @Test
    public void unCalculadorDeCostosCalculaCorrectamenteElCostoDeUnEnvioDe10PaquetesOMas() {
        CalculadorDeCostos calculador = new CalculadorDeCostos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(1);
        pesos.add(2);
        pesos.add(3);
        pesos.add(4);
        pesos.add(5);
        pesos.add(6);
        pesos.add(7);
        pesos.add(8);
        pesos.add(9);
        pesos.add(10);
        pesos.add(11);

        Assertions.assertThat(calculador.calcular(pesos)).isEqualTo(102);
    }

    @Test
    public void unAsignadorDeVehiculosDebePoderCrearse() {
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();

        Assertions.assertThat(asignador).isNotNull();
    }

    @Test
    public void unAsignadorDeVehiculosDebeAsignarUnaBicicletaAUnEnvioDeHasta5Kg() {
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(1);
        pesos.add(2);
        pesos.add(2);

        Assertions.assertThat(asignador.asignar(pesos)).isEqualTo("Bicicleta");
    }

    @Test
    public void unAsignadorDeVehiculosDebeAsignarUnAutoAUnEnvioDeHasta50Kg() {
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(1);
        pesos.add(2);
        pesos.add(3);
        pesos.add(4);
        pesos.add(20);

        Assertions.assertThat(asignador.asignar(pesos)).isEqualTo("Auto");
    }

    @Test
    public void unAsignadorDeVehiculosDebeAsignarUnaCamionetaAUnEnvioDeHasta150Kg() {
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(50);
        pesos.add(50);
        pesos.add(50);

        Assertions.assertThat(asignador.asignar(pesos)).isEqualTo("Camioneta");
    }

    @Test
    public void unAsignadorDeVehiculosNoDebeAsignarUnVehiculoAUnEnvioDe0OMenosKg() {
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(0);

        Assertions.assertThat(asignador.asignar(pesos)).isNull();
    }

    @Test
    public void unAsignadorDeVehiculosNoDebeAsignarUnVehiculoAUnEnvioDeMasDe150Kg() {
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(50);
        pesos.add(50);
        pesos.add(50);
        pesos.add(1);

        Assertions.assertThat(asignador.asignar(pesos)).isNull();
    }

    @Test
    public void unDespachantePuedeCrearse() {
        Despachante despachante = Despachante.getInstance();

        Assertions.assertThat(despachante).isNotNull();
    }

    @Test
    public void noPuedeCrearseMasDeUnDespachante() {
        Despachante despachante1 = Despachante.getInstance();
        Despachante despachante2 = Despachante.getInstance();

        Assertions.assertThat(despachante1).isEqualTo(despachante2);
    }

    @Test
    public void unEnvioPuedeCrearse() {
        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(1);
        pesos.add(2);
        pesos.add(3);

        Envio envio = Envio.getInstance(pesos, "Calle falsa 123", 2, "Bici");

        Assertions.assertThat(envio).isNotNull();
    }

    @Test
    public void unDespachanteNoDebeGenerarUnEnvioConMasDe150Kg() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setCalculadorDeCostos(calculadorDeCostos);
        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(100);
        pesos.add(200);
        pesos.add(300);

        Envio envio = despachante.generarEnvio(pesos, "Calle Falsa 123");

        Assertions.assertThat(envio).isNull();
    }

    @Test
    public void unEnvioNoPuedeCrearseCon0OMenosKg() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setCalculadorDeCostos(calculadorDeCostos);
        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);

        ArrayList<Integer> pesos = new ArrayList<>();

        pesos.add(-100);
        pesos.add(-200);
        pesos.add(-300);

        Envio envio = despachante.generarEnvio(pesos, "Calle falsa 123");

        Assertions.assertThat(envio).isNull();
    }

    @Test
    public void unEnvioNoPuedeCrearseConListaVaciaDePesosDePaquetes() {
        Despachante despachante = Despachante.getInstance();

        ArrayList<Integer> pesos = new ArrayList<>();

        Envio envio = despachante.generarEnvio(pesos, "Calle Falsa 123");

        Assertions.assertThat(envio).isNull();
    }

    @Test
    public void unEnvioNoPuedeCrearseConListaNullDePesosDePaquetes() {
        Despachante despachante = Despachante.getInstance();

        ArrayList<Integer> pesos = null;

        Envio envio = despachante.generarEnvio(pesos, "Calle Falsa 123");

        Assertions.assertThat(envio).isNull();
    }

    @Test
    public void unDespachantePuedeCalcularElCostoDeUnEnvioDeMenosDe5Paquetes() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);
        despachante.setCalculadorDeCostos(calculadorDeCostos);

        ArrayList<Integer> pesosDePaquetes = new ArrayList<>();

        pesosDePaquetes.add(1);
        pesosDePaquetes.add(2);
        pesosDePaquetes.add(3);

        int costo = despachante.getCalculadorDeCostos().calcular(pesosDePaquetes);

        Assertions.assertThat(costo).isEqualTo(45);
    }

    @Test
    public void unDespachantePuedeCalcularElCostoDeUnEnvioDeMasDe5YMenosDe10Paquetes() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);
        despachante.setCalculadorDeCostos(calculadorDeCostos);

        ArrayList<Integer> pesosDePaquetes = new ArrayList<>();

        pesosDePaquetes.add(1);
        pesosDePaquetes.add(2);
        pesosDePaquetes.add(3);
        pesosDePaquetes.add(4);
        pesosDePaquetes.add(5);
        pesosDePaquetes.add(6);

        int costo = despachante.getCalculadorDeCostos().calcular(pesosDePaquetes);

        Assertions.assertThat(costo).isEqualTo(72);
    }

    @Test
    public void unDespachantePuedeCalcularElCostoDeUnEnvioDeMasDe10PaquetesOMas() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);
        despachante.setCalculadorDeCostos(calculadorDeCostos);

        ArrayList<Integer> pesosDePaquetes = new ArrayList<>();

        pesosDePaquetes.add(1);
        pesosDePaquetes.add(2);
        pesosDePaquetes.add(3);
        pesosDePaquetes.add(4);
        pesosDePaquetes.add(5);
        pesosDePaquetes.add(6);
        pesosDePaquetes.add(7);
        pesosDePaquetes.add(8);
        pesosDePaquetes.add(9);
        pesosDePaquetes.add(10);
        pesosDePaquetes.add(11);

        int costo = despachante.getCalculadorDeCostos().calcular(pesosDePaquetes);

        Assertions.assertThat(costo).isEqualTo(102);
    }

    @Test
    public void unDespachantePuedeGenerarUnEnvioConPaquetesQueNoExcedenLos150KgEnTotal() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);
        despachante.setCalculadorDeCostos(calculadorDeCostos);

        ArrayList<Integer> pesosDePaquetes = new ArrayList<>();

        pesosDePaquetes.add(1);
        pesosDePaquetes.add(2);
        pesosDePaquetes.add(3);

        Envio envio = despachante.generarEnvio(pesosDePaquetes, "Calle Falsa 123");

        Assertions.assertThat(envio).isNotNull();
    }

    @Test
    public void unDespachanteNoDebePoderGenerarUnEnvioConPaquetesQueExcedenLos150KgEnTotal() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);
        despachante.setCalculadorDeCostos(calculadorDeCostos);

        ArrayList<Integer> pesosDePaquetes = new ArrayList<>();

        pesosDePaquetes.add(100);
        pesosDePaquetes.add(50);
        pesosDePaquetes.add(1);

        Envio envio = despachante.generarEnvio(pesosDePaquetes, "Calle Falsa 123");

        Assertions.assertThat(envio).isNull();
    }

    @Test
    public void unDespachanteDebeAsignarUnPedidoDe5KgOMenosAUnaBicicleta() {
        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();
        AsignadorDeVehiculos asignadorDeVehiculos = new AsignadorDeVehiculos();

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculos);
        despachante.setCalculadorDeCostos(calculadorDeCostos);

        ArrayList<Integer> pesosDePaquetes = new ArrayList<>();

        pesosDePaquetes.add(2);
        pesosDePaquetes.add(2);
        pesosDePaquetes.add(1);

        String vehiculo = despachante.getAsignadorDeVehiculos().asignar(pesosDePaquetes);

        Assertions.assertThat(vehiculo).isEqualTo("Bicicleta");
    }

    public void unDespachanteDebeGenerarCorrectamenteUnEnvio() {

        Despachante despachante = Despachante.getInstance();
        CalculadorDeCostos calculadorDeCostosMock = mock(CalculadorDeCostos.class);
        AsignadorDeVehiculos asignadorDeVehiculosMock = mock(AsignadorDeVehiculos.class);

        despachante.setAsignadorDeVehiculos(asignadorDeVehiculosMock);
        despachante.setCalculadorDeCostos(calculadorDeCostosMock);

        when(calculadorDeCostosMock.calcular(new ArrayList<>())).thenReturn(45);
        when(asignadorDeVehiculosMock.asignar(new ArrayList<>())).thenReturn("Bicicleta");

        Envio envio = despachante.generarEnvio(new ArrayList<>(), "CalleFalsa 123");

        Assertions.assertThat(envio.getCosto()).isEqualTo(45);
        Assertions.assertThat(envio.getTransporte()).isEqualTo("Bicicleta");
        Assertions.assertThat(envio.getDireccion()).isEqualTo("CalleFalsa 123");
    }

}
