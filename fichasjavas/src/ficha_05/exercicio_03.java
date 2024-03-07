package ficha_05;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        int maiornum;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int i = 0; i <= arrayNumeros.length - 1; ++i) {
            System.out.print("Introduza um numero na array[" + i + "] : ");
            arrayNumeros[i] = input.nextInt();
        }
        maiornum = arrayNumeros[0];
        for (int i = 1; i <= arrayNumeros.length - 1; ++i) {
            if (arrayNumeros[i] > maiornum) {
                maiornum = arrayNumeros[i];
            }
        }
        System.out.println("O maior numero é :" + maiornum);
    }
}
