package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de arrays >>>>>\n");
        System.out.print("Quantos numeros deseja inserir no array : ");
        int[] array = new int[input.nextInt()];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            array[i] = input.nextInt();
        }
        System.out.println();

        System.out.println("Qual o numero que quer remover? : ");
        int numeroRemover = input.nextInt();
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroRemover) {
                contador++;
            }
        }

        if (contador > 0) {
            int[] newArray = new int[array.length - contador];
            contador = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != numeroRemover) {
                    newArray[contador] = array[i];
                    contador++;
                }
            }
            for (int i = 0; i < newArray.length; i++)
            {
                System.out.print("Array[" + i + "]: " + newArray[i] + " ");
            }
            System.out.println();
        }else {

            System.out.println("Nao existe esse numero a remover!");
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
