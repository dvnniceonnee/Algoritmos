package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numerosRepetidos = new int[12];
        boolean existeRepetidos = false;

        for (int i = 0; i < numerosRepetidos.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            numerosRepetidos[i] = input.nextInt();
        }

        for (int i = 0; i < numerosRepetidos.length; i++) {
            int numero_Dup = numerosRepetidos[i];
            boolean remove = false;
            int contador = 0;
            for (int k = 0; k < numerosRepetidos.length && k != i; k++) {
                if (numerosRepetidos[k] == numero_Dup) {
                    remove = true;
                    ++contador;
                }
            }
            if (remove) {
                ++contador;
                int[] arrayTemp = new int[numerosRepetidos.length - contador];
                contador = 0;
                for (int k = 0; k < numerosRepetidos.length; k++) {
                    if (numerosRepetidos[k] != numero_Dup) {
                        arrayTemp[contador] = numerosRepetidos[k];
                        ++contador;
                    }
                }
                existeRepetidos = true;
                i = 0;
                numerosRepetidos = arrayTemp;
            }
        }
        if (existeRepetidos) {
            System.out.println("Existem " + (12 - numerosRepetidos.length) + " numeros repetidos!\n");
            for (int i = 0; i < numerosRepetidos.length; i++) {
                System.out.println(numerosRepetidos[i] + "\t");
            }
        }
        else
        {
            System.out.println("Nao existem numeros repetidos!");
        }

    }
}
