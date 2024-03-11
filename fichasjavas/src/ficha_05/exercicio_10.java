package ficha_05;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int[][] matrizNumeros = new int[3][5];
        int numeroPesquisa, contador = 0;


        for (int l = 0; l < matrizNumeros.length; l++) {
            for (int c = 0; c < matrizNumeros[0].length; c++) {
                System.out.print("Introduza um numero na matriz [" + l + "]" + "[" + c + "] :");
                matrizNumeros[l][c] = input.nextInt();
            }
        }
        System.out.print("Introduza um numero para pesquisar : ");
        numeroPesquisa = input.nextInt();

        for (int c = 0; c < matrizNumeros.length; c++) {
            for (int l = 0; l < matrizNumeros[0].length; l++) {
                System.out.print(matrizNumeros[c][l] + "\t");
                if (numeroPesquisa == matrizNumeros[c][l]) {
                    ++contador;
                }
            }
            System.out.println();
        }

        System.out.println("\nExiste " + contador + " posições na matriz com o numero " + numeroPesquisa);

    }
}
