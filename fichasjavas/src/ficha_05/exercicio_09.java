package ficha_05;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int soma = 0;
        int[][] matrizNumeros = new int[5][5];

        // Ler as variaveis
        for (int i = 0; i < matrizNumeros.length ;i++ )
        {
            for(int e = 0 ; e < matrizNumeros[0].length ; e++)
            {
                System.out.print("Introduza um numero inteiro : ");
                matrizNumeros[i][e] = input.nextInt();
                soma = soma + matrizNumeros[i][e];
            }
        }

        System.out.println("A soma é : " + soma);
    }
}
