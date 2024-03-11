package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de Matrizes >>>>>\n");

        System.out.print("Introduza quantas linhas quer na matriz:");
        int linhas = input.nextInt();                                   // variavel guardada para o numero de linhas que o utilizador quer
        System.out.print("Introduza quantas colunas quer na matriz: ");
        int colunas = input.nextInt();                                  // variavel para o numero de colunas que o utilizador quer

        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < matriz.length; i++) {                                   // leitura e introduçao dos elementos na matriz
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print("Introduza um numero na matriz [" + i + "][" + k + "] : ");
                matriz[i][k] = input.nextInt();
            }
        }
        System.out.println("\n *** Matriz Inicial ****\n");                     // Apresentação da matriz na consola
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print(matriz[i][k] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");

        int[][] matrizTransposta = new int[matriz[0].length][matriz.length];    // nova matriz transposta


        for (int i = 0; i < matrizTransposta.length; i++) {                     // leitura da matriz tranposta com os elementos da matriz original
            for (int k = 0; k < matrizTransposta[0].length; k++) {              // as colunas da matriz original sao as linhas da matriz transposta
                matrizTransposta[i][k] = matriz[k][i];                          // as linhas da matriz original sao as colunas da matriz transposta
            }
        }

        System.out.println("\n *** Matriz Transposta ****\n");
        for (int i = 0; i < matrizTransposta.length || i < matriz.length; i++) {  // leitura das duas matrizes (i é menor do que o maximo do maior tamanho das duas matrizes em questao de tamanho de linhas
            if (matrizTransposta.length > i) {                                     // imprime apenas se o tamanho é maior do que "i"
                for (int k = 0; k < matrizTransposta[0].length; k++) {
                    System.out.print(matrizTransposta[i][k] + "\t");
                }
            } else {
                for (int k = 0; k < matrizTransposta[0].length; k++)                // imprime espaços para a proxima matriz ficar graficamente ben
                    System.out.print(" \t");
            }
            System.out.print("\t| \t");
            if (matriz.length > i) {
                for (int k = 0; k < matriz[0].length; k++) {                        // linha 43
                    System.out.print(matriz[i][k] + "\t");
                }
            } else {
                for (int k = 0; k < matriz[0].length; k++)                          // linha 49
                    System.out.print(" \t");
            }
            System.out.println();
        }
    }
}
