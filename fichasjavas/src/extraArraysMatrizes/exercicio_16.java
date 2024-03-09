package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de matrizes >>>>>\n");
        double[][] matriz = new double[3][3];
        double maiorElemento, menorElemento;

        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.println("Introduza um numero na matriz[" + i + "][" + k + "]: ");
                matriz[i][k] = input.nextInt();
            }
        }
        maiorElemento = matriz[0][0];
        menorElemento = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                if (matriz[i][k] > maiorElemento)
                    maiorElemento = matriz[i][k];
                else if (matriz[i][k] < menorElemento)
                    menorElemento = matriz[i][k];
                System.out.print(matriz[i][k] + "\t");
            }
            System.out.println();
        }
        System.out.println("O maior é : " + maiorElemento);
        System.out.println("O menor é : " + menorElemento);
    }
}
