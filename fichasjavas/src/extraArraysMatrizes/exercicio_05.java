package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_05 {
    public static int[] valoresDuplicados(int[] array) {

        int[] vetorNumerosRepetidos = new int[array.length];
        int contadorNumerosRepetidos = 0;

        for (int i = 0; i < array.length; i++) {
            boolean repete = false;
            for (int k = 1; k <= contadorNumerosRepetidos; k++) {
                if (array[i] == vetorNumerosRepetidos[k]) {
                    repete = true;
                    k = vetorNumerosRepetidos.length;
                }
            }
            if (!repete) {
                for (int u = 0; u < array.length; u++) {
                    if (i != u && array[i] == array[u] && array[u] != 0) {
                        vetorNumerosRepetidos[contadorNumerosRepetidos + 1] = array[i];
                        ++contadorNumerosRepetidos;
                        u = array.length;
                    }
                }
            }
        }
        vetorNumerosRepetidos[0] = contadorNumerosRepetidos; // Na primeira posiçao retorna o numero de numeros repetidos que existem na array
        return vetorNumerosRepetidos;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] vetorNumeros = new int[12];
        int contadorZeros = 0;
        int[] vetorNumerosRepetidos = new int[12];

        for (int i = 0; i < vetorNumeros.length; i++) {
            System.out.print("Introduza um numero na Array[" + i + "]: ");
            vetorNumeros[i] = input.nextInt();
            if (vetorNumeros[i] == 0)
                ++contadorZeros;
        }
        vetorNumerosRepetidos = valoresDuplicados(vetorNumeros);
        if (vetorNumerosRepetidos[0] > 0 || contadorZeros > 1) { // Verificar se existe numeros repetidos
            System.out.println("\nNumeros repetidos : ");
            if (vetorNumerosRepetidos[0] > 0) {
                vetorNumerosRepetidos = valoresDuplicados(vetorNumeros);
                for (int i = 1; i < vetorNumerosRepetidos.length; i++) {
                    if (vetorNumerosRepetidos[i] != 0) {
                        System.out.println(vetorNumerosRepetidos[i]);
                    }
                }
            }
            if (contadorZeros > 1) {
                System.out.println("0 ");
            }
        } else {
            System.out.println("Nao existe numeros repetidos!");
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
