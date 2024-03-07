package ficha_06;

import java.util.Scanner;

public class exercicio_08 {
    public static int[][] somarMatriz(int[][] matriz1, int[][] matriz2) {
        int[][] conjuntoMatrizes = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int k = 0; k < matriz1[0].length; k++) {
                conjuntoMatrizes[i][k] = matriz1[i][k] + matriz1[i][k];
            }
        }
        return conjuntoMatrizes;
    }

    public static void imprimirMatrizes(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print(matriz[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static int somatorioMatrizes(int[][] matriz1, int[][] matriz2) {
        int somatorio = 0;
        for (int i = 0; i < matriz1.length; i++) {
            for (int k = 0; k < matriz1.length; k++){
                somatorio = somatorio + matriz1[i][k] + matriz2[i][k];
            }
        }
        return somatorio;
    }

    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        int[][] matriz1 = new int[3][3], matriz2 = new int[3][3];
        int somatorio;

        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                for (int k = 0; k < matriz1.length; k++) {
                    for (int n = 0; n < matriz1.length; n++) {
                        System.out.println("Introduza um numero na matriz1[" + k + "]" + "[" + n + "]:");
                        matriz1[k][n] = input.nextInt();
                    }
                }
            } else {
                for (int k = 0; k < matriz2.length; k++) {
                    for (int n = 0; n < matriz2.length; n++) {
                        System.out.println("Introduza um numero na matriz2[" + k + "]" + "[" + n + "]:");
                        matriz2[k][n] = input.nextInt();
                    }
                }
            }
        }
        imprimirMatrizes(matriz1);
        System.out.println();
        imprimirMatrizes(matriz2);
        System.out.println();
        imprimirMatrizes(somarMatriz(matriz1, matriz2));
        somatorio =  somatorioMatrizes(matriz1, matriz2);

        System.out.println("\nO somatório é :" + somatorio);
    }
}
