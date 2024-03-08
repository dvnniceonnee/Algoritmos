package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de arrays >>>>>\n");
        System.out.print("Quantos numeros deseja inserir no array : ");
        int[] array = new int[input.nextInt()];
        int[] arrayCrescente = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            array[i] = input.nextInt();
        }
        for (int k = 0; k < arrayCrescente.length; k++) {
            int numeroMenor = array[k];
            for (int i = 0; i < array.length; i++) {
                if (numeroMenor > array[i]) {
                    numeroMenor = array[i];
                }
            }
            arrayCrescente[k] = numeroMenor;
        }

        for (int i = 0; i < arrayCrescente.length; i++)
        {
            System.out.print(arrayCrescente[i] + "\t");
        }
    }
}
