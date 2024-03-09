package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[4][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++)
            {
                System.out.print("Introduza um numero na matriz[" + i + "]" + "[" + k + "] :");
                matriz[i][k] =  input.nextInt();
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++)
            {
                System.out.print(matriz[i][k] + "\t");
            }
            System.out.println();
        }
    }
}
