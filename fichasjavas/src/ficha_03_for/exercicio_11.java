package ficha_03_for;

import java.util.Scanner;

public class exercicio_11 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int number_limit, number_salto, number_referencia = 0 ;

        // Ler as variaveis
        System.out.println("<<<<< Programa de saltos >>>>>\n");
        System.out.print("Introduza um limite : ");
        number_limit = input.nextInt();
        System.out.print("Introduza um salto : ");
        number_salto = input.nextInt();

        for (number_referencia = number_referencia; number_referencia <= number_limit; number_referencia =  number_referencia + number_salto) // para o numero de refencia, enquanto for menor do que o numero limite apresentar o numero, e acrescentar o numero + o salto
        {
            System.out.println("- " + number_referencia);
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
