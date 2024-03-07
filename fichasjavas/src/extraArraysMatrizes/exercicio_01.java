package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        // variaveis
        int[] array = new int[14];

        // Ler os numeros para cada posicao do array
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("Introduza um numero no array[" + i +"]:");
            array[i] =  input.nextInt();
        }
        System.out.println();
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
