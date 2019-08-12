package tragamonedas;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tragamonedas tragamonedas = new Tragamonedas(new Tambor(), new Tambor(), new Tambor());

        int respuesta;

        System.out.println("Activar tragamonedas? 1 = Sí, Otro = No");
        respuesta = scanner.nextInt();
        while(respuesta == 1) {
            tragamonedas.activar();

            mostrarPosiciones(tragamonedas.verPosicionesDeTambores());
            mostrarPremio(tragamonedas.entregaPremio());
            System.out.println("Activar tragamonedas? 1 = Sí, Otro = No");
            respuesta = scanner.nextInt();
        }

    }

    private static void mostrarPosiciones(int[] posiciones) {
        System.out.println(String.format("%d %d %d", posiciones[0], posiciones[1], posiciones[2]));
    }

    private static void mostrarPremio(boolean entregaPremio) {
        if (entregaPremio)
            System.out.println("Ganaste!");
        else
            System.out.println("Mejor suerte la próxima");
    }

}
