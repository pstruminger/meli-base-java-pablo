package tragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TragamonedasTest {

    @Test
    public void unTamborSePuedeCrear() {
        Tambor tambor = new Tambor();

        Assertions.assertThat(tambor).isNotNull();
    }

    @Test
    public void unTamborSeCreaConPosicion0() {
        Tambor tambor = new Tambor();

        Assertions.assertThat(tambor.obtenerPosicion()).isEqualTo(0);
    }

    @Test
    public void unTamborPuedeGirar() {
        Tambor tambor = new Tambor();

        tambor.girar();

        Assertions.assertThat(tambor.obtenerPosicion()).isBetween(1,8);
    }

    @Test
    public void unTragamonedasPuedeCrearseConTambores() {
        Tambor tambor1 = new Tambor();
        Tambor tambor2 = new Tambor();
        Tambor tambor3 = new Tambor();

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        Assertions.assertThat(tragamonedas).isNotNull();
    }

    @Test
    public void unTragamonedasPuedeActivarse() {
        Tambor tambor1 = new Tambor();
        Tambor tambor2 = new Tambor();
        Tambor tambor3 = new Tambor();

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);
        tragamonedas.activar();

        int[] posiciones = tragamonedas.verPosicionesDeTambores();

        Assertions.assertThat(posiciones[0]).isBetween(1,8);
        Assertions.assertThat(posiciones[1]).isBetween(1,8);
        Assertions.assertThat(posiciones[2]).isBetween(1,8);
    }

    @Test
    public void unTragamonedasDebeGirarLos3TamboresAlActivarse() {
        Tambor tamborMock1 = mock(Tambor.class);
        Tambor tamborMock2 = mock(Tambor.class);
        Tambor tamborMock3 = mock(Tambor.class);

        //when(tamborMock1.obtenerPosicion()).thenReturn(3);
        //when(tamborMock2.obtenerPosicion()).thenReturn(3);
        //when(tamborMock3.obtenerPosicion()).thenReturn(3);

        Tragamonedas tragamonedas = new Tragamonedas(tamborMock1, tamborMock2, tamborMock3);
        tragamonedas.activar();

        verify(tamborMock1, times(1)).girar();
        verify(tamborMock2, times(1)).girar();
        verify(tamborMock3, times(1)).girar();
    }

    @Test
    public void unTragamonedasDebeEntregarUnPremioSiLos3TamboresQuedanEnLaMismaPosicionDespuesDeActivarse() {
        Tambor tamborMock1 = mock(Tambor.class);
        Tambor tamborMock2 = mock(Tambor.class);
        Tambor tamborMock3 = mock(Tambor.class);

        when(tamborMock1.obtenerPosicion()).thenReturn(3);
        when(tamborMock2.obtenerPosicion()).thenReturn(3);
        when(tamborMock3.obtenerPosicion()).thenReturn(3);

        Tragamonedas tragamonedas = new Tragamonedas(tamborMock1, tamborMock2, tamborMock3);
        tragamonedas.activar();

        Assertions.assertThat(tragamonedas.entregaPremio()).isTrue();
    }

    @Test
    public void unTragamonedasNoDebeEntregarUnPremioSiLos3TamboresNoQuedanEnLaMismaPosicionDespuesDeActivarse() {
        Tambor tamborMock1 = mock(Tambor.class);
        Tambor tamborMock2 = mock(Tambor.class);
        Tambor tamborMock3 = mock(Tambor.class);

        when(tamborMock1.obtenerPosicion()).thenReturn(1);
        when(tamborMock2.obtenerPosicion()).thenReturn(3);
        when(tamborMock3.obtenerPosicion()).thenReturn(3);

        Tragamonedas tragamonedas = new Tragamonedas(tamborMock1, tamborMock2, tamborMock3);
        tragamonedas.activar();

        Assertions.assertThat(tragamonedas.entregaPremio()).isFalse();
    }
}
