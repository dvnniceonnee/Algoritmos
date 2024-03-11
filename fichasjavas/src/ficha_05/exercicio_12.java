package ficha_05;

import java.util.Scanner;

public class exercicio_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar as arrays
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        for (int i = 1; i <= 2; i++) {
            for (int l = 0; l < 10; l++) {
                if (i == 1) {
                    System.out.print("Introduza um numero na array1[" + l + "]:");
                    array1[l] = input.nextInt();
                } else if (i == 2) {
                    System.out.print("Introduza um numero na array2[" + l + "]:");
                    array2[l] = input.nextInt();
                }
            }
            System.out.println(" ");
        }

        int[][] matriz = new int[10][2];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][0] = array1[i];
            matriz[i][1] = array2[i];
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print(matriz[i][k] + " ");
            }
            System.out.println();
        }

        System.out.println("\n <<<<<< Fim de Programa >>>>>");
    }
}
