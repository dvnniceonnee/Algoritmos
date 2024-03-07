package ficha_05;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        double somatorio = 0;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int i = 0; i < arrayNumeros.length ; ++i) {
            System.out.print("Introduza um numero na array[" + i + "] : ");
            arrayNumeros[i] = input.nextInt();
            somatorio = somatorio + arrayNumeros[i];
        }
        System.out.println("A media dos 10 elementos é : " + (somatorio / arrayNumeros.length));
    }
}
