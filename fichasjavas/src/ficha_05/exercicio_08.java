package ficha_05;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner  input = new Scanner(System.in);

        // Declarar variaveis
        int[][] matrizNumeros = new int[3][3];

        // Ler as variaveis
        for (int i = 0; i < matrizNumeros.length ;i++ )
        {
            for(int e = 0 ; e < matrizNumeros[0].length ; e++)
            {
                System.out.print("Introduza um numero inteiro (0-9) : ");
                matrizNumeros[i][e] = input.nextInt();
            }
        }

        for (int i = 0; i < matrizNumeros.length ;i++ )
        {
            for(int e = 0 ; e < matrizNumeros[0].length ; e++)
            {
                System.out.print(matrizNumeros[i][e] + " ");
            }
            System.out.println(" ");
        }
    }
}
