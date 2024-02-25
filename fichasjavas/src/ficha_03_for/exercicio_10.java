package ficha_03_for;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        // Impotar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int numero, number_helper = 2;

        // Ler as variaveis
        System.out.println("<<<<< Programa de numeros pares >>>>>\n");
        System.out.print("Introduza um numero : ");
        numero = input.nextInt();

        for (number_helper = number_helper ; number_helper <= numero; number_helper++) // para o numero de refencia, enquanto for menor do que o numero introduzido pelo utilizador realizar o codigo, e acrescentar 1
        {
            if ((number_helper % 2) == 0 ||  number_helper ==  numero) // se o numero for par apresentar ou se for igual ao numero introduzido pelo utilizador
            {
                System.out.println("- " + number_helper);
            }
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
