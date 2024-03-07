package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_05 {
    public static int[] valoresDuplicados(int[] array) {

        int[] vetorNumerosRepetidos = new int[12];
        int contadorNumerosRepetidos = 1;
        int numeroRepetido = 0;

        for (int i = 0; i < array.length; i++) {
            numeroRepetido = 0;
            for (int u = 1; u < vetorNumerosRepetidos.length; u++)
            {
                if (array[i] != vetorNumerosRepetidos[u])
                {
                    for (int k = 0; k < array.length; k++) {
                        if (k != i) {
                            if (array[i] == array[k] && array[k] != numeroRepetido && array[k] != 0) {
                                numeroRepetido = array[k];
                                vetorNumerosRepetidos[contadorNumerosRepetidos] = array[k];
                                contadorNumerosRepetidos++;
                            }
                        }
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
                contadorZeros++;
        }
        if (valoresDuplicados(vetorNumeros)[0] > 0 || contadorZeros > 0) {
            System.out.println("Numeros repetidos: ");
            if (contadorZeros > 0)
                System.out.println("0");
            else if (valoresDuplicados(vetorNumeros)[0] > 0) {
                vetorNumerosRepetidos = valoresDuplicados(vetorNumeros);
                for (int i = 1; i < vetorNumerosRepetidos.length; i++) {
                    if (vetorNumerosRepetidos[i] != 0) {
                        System.out.println(vetorNumerosRepetidos[i]);
                    }
                }
            }
        } else {
            System.out.println("Nao existe numeros repetidos!");
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
