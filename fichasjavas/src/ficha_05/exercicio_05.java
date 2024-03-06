package ficha_05;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        int media, somatorio = 0;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int quantNumeros = 0; quantNumeros <= arrayNumeros.length - 1; ++quantNumeros) {
            System.out.print("Introduza um numero na array[" + quantNumeros + "] : ");
            arrayNumeros[quantNumeros] = input.nextInt();
            somatorio = somatorio + arrayNumeros[quantNumeros];
        }
        media = somatorio / arrayNumeros.length;
        System.out.println("A media dos 10 elementos é :" + media);
    }
}
