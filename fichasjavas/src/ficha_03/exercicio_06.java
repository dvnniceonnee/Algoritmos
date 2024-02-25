package ficha_03;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int number1, number2;

        // Ler as variaveis
        System.out.println("<<<<< Programa de numeros inteiros e Whiles >>>>>\n");
        System.out.print("Introduza um numero de inicio : ");
        number1 = input.nextInt(); // Ler numero 1
        System.out.print("Introduza um numero de fim : ");
        number2 = input.nextInt(); // Ler numero 2

        while (number1 <= number2) // Enquanto o numero 1 for mais pequeno do que o numero 2 continua o loop
        {
            System.out.println(" " + number1); // Imprimir o numero
            number1 = ++number1; // Incremento de 1 para mostrar o proximo numero no proximo loop
        }

    }
}
