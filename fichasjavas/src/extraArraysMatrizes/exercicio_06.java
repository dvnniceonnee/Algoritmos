package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<<< Programa de arrays >>>>>\n");
        System.out.print("Quantos elementos quer inserir no Array :");
        int[] array = new int[input.nextInt()];

        for (int i = 0; i < array.length; i++){
            System.out.print("Introduza um numero no Array[" +i + "]:");
            array[i] = input.nextInt();
        }
        System.out.println();
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");

    }
}
