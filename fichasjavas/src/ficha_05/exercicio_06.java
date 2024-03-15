package ficha_05;

import java.util.Scanner;


public class exercicio_06 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        boolean crescent = true;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int i = 0; i < arrayNumeros.length; ++i) {
            System.out.print("Introduza um numero na array[" + i + "] : ");
            arrayNumeros[i] = input.nextInt();
        }
        for (int i = 1; i < arrayNumeros.length; i++) // variavel local
        {
            if (arrayNumeros[i - 1] > arrayNumeros[i]) {
                crescent = false;
                i = arrayNumeros.length;
            }
        }
        if (crescent) {
            System.out.println("A ordem é crescente");
        } else {
            System.out.println("A ordem nao é crescente");
        }
    }
}
