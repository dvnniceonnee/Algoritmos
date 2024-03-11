package ficha_05;

import java.util.Scanner;

public class exercicio_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int[][] matrizNumeros = new int[3][3];
        int maiorNumero, menorNumero;

        for (int l = 0; l < matrizNumeros.length; l++) {
            for (int c = 0; c < matrizNumeros[0].length; c++) {
                System.out.print("Introduza um numero na matriz [" + l + "]" + "[" + c + "] : ");
                matrizNumeros[l][c] = input.nextInt();
            }
        }
        maiorNumero = matrizNumeros[0][0];
        menorNumero = maiorNumero;
        for (int l = 0; l < matrizNumeros.length; l++) {
            for (int c = 0; c < matrizNumeros[0].length; c++) {
                System.out.print(matrizNumeros[l][c] + "\t");
                if (matrizNumeros[l][c] > maiorNumero) {
                    maiorNumero = matrizNumeros[l][c];
                } else if (matrizNumeros[l][c] < menorNumero) {
                    menorNumero = matrizNumeros[l][c];
                }
            }
            System.out.println();
        }
        System.out.println("\n Menor : " + menorNumero);
        System.out.println("\n Maior : " + maiorNumero);

    }
}
