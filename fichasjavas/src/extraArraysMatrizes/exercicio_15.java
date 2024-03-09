package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de matrizes >>>>>\n");
        int[][] matriz = new int[3][2];

        for (int i = 0; i < matriz.length; i++)
        {
            for (int k = 0; k < matriz[0].length; k++)
            {
                System.out.print("Introduza um numero na matriz[" + i +  "][" + k + "]:");
                matriz[i][k] = input.nextInt();
            }
        }
        int media = 0;
        for (int i = 0; i < matriz.length; i++)
        {
            for (int k = 0; k < matriz[0].length; k++)
            {
                media = media + matriz[i][k];
            }
        }
        media = media/ (matriz.length * matriz[0].length);
        System.out.println("A média é : " + media);
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
