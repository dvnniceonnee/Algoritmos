package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de arrays >>>>>\n");
        System.out.print("Quantos numeros deseja inserir no array : ");
        int[] array = new int[input.nextInt()];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            array[i] = input.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("["+i+"] : " + array[i] + " ");
        }
        System.out.println();
        System.out.print("Qual o novo numero que deseja inserir :");
        int numeroAinserir = input.nextInt();
        System.out.println("Em que posição deseja inserir? : ");
        int posicaoNum = input.nextInt();

        int[] arrayNova = new int[array.length + 1];

        for (int i = 0; i < arrayNova.length; i++) {
            if (i < posicaoNum) {
                arrayNova[i] = array[i];
            } else if (i == posicaoNum) {
                arrayNova[i] = numeroAinserir;
            } else if (i > posicaoNum) {
                arrayNova[i] = array[i - 1];
            }
        }
        for (int i = 0; i < arrayNova.length; i++) {
            System.out.println("["+i+"] : " + arrayNova[i] + " ");
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");

    }
}
