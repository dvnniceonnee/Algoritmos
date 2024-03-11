package ficha_05;

import java.util.Scanner;

public class exercicio_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // declarar a matriz
        int[][] matriz = new int[4][4];
        int soma = 0;

        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.print("Introduza um numero na matriz[" + l + "]" + "[" + c + "]:");
                matriz[l][c] = input.nextInt();
            }
        }
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.print(matriz[l][c] + " ");
            }
            System.out.println();
        }
        for (int l = 0; l < matriz.length; l++) {
            soma = soma + matriz[l][l];
        }
        System.out.println("\nA soma é : " + soma);
    }
}
