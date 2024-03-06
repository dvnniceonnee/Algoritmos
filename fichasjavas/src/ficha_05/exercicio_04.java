package ficha_05;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        int maiornum;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int quantNumeros = 0; quantNumeros <= arrayNumeros.length - 1; ++quantNumeros) {
            System.out.print("Introduza um numero na array[" + quantNumeros + "] : ");
            arrayNumeros[quantNumeros] = input.nextInt();
        }
        maiornum = arrayNumeros[0];
        for (int quantNumeros = 1; quantNumeros <= arrayNumeros.length - 1; ++quantNumeros)
        {
            if (arrayNumeros[quantNumeros] < maiornum)
            {
                maiornum = arrayNumeros[quantNumeros];
            }
        }
        System.out.println("O menor numero é :" + maiornum);
    }
}
