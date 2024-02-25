package ficha_03_for;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // declarar variaveis
        int number, number_helper;

        // Ler Variaveis
        System.out.println("<<<<< Programa de numeros >>>>>\n");
        System.out.print("Introduza um numero : ");
        number = input.nextInt();

        for (number_helper = 0; number_helper <= number; number_helper++) // Para o number_helper que começa no 0, enquanto for menor do que o numero limite introduzido pelo utilizar, correr o codigo e acrescenta 1
        {
            System.out.println("- " + number_helper);
        }

        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
