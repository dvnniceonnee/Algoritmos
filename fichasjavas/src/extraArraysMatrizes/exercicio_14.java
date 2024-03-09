package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz1 = new int[3][3];
        int[][] matriz2 = new int[3][3];

        System.out.println("<<<<<< Programa de matrizes >>>>>\n");

        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                for (int k = 0; k < matriz1.length; k++) {
                    for (int j = 0; j < matriz1[0].length; j++) {
                        System.out.print("Introduza um numero na matriz1[" + k + "][" + j + "]:");
                        matriz1[k][j] = input.nextInt();
                    }
                }
                System.out.println("\n");
            } else {
                for (int k = 0; k < matriz2.length; k++) {
                    for (int j = 0; j < matriz2[0].length; j++) {
                        System.out.print("Introduza um numero na matriz2[" + k + "][" + j + "]:");
                        matriz2[k][j] = input.nextInt();
                    }
                }
                System.out.println("\n");
            }
        }

        for (int i = 0; i < matriz1.length; i++) {
            for (int k = 0; k < matriz1[0].length; k++) {
                System.out.print(matriz1[i][k] + "\t");
            }
            System.out.print("|\t");
            for (int k = 0; k < matriz2[0].length; k++) {
                System.out.print(matriz2[i][k] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");

        int[][] matrizSoma = new int[3][3];

        for (int i = 0; i < matrizSoma.length; i++) {
            for (int k = 0; k < matrizSoma[0].length; k++) {
                matrizSoma[i][k] = matriz1[i][k] + matriz2[i][k];
                System.out.print(matrizSoma[i][k] + "\t");
            }
            System.out.println();
        }
    }
}
