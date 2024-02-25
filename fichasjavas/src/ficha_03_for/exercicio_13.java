package ficha_03_for;

import java.util.Scanner;

public class exercicio_13 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int number_inicio, number_fim, number_referencia = 0;

        // Ler as variaveis
        System.out.println("<<<<< Programa de multiplos de 5 >>>>>\n");
        System.out.print("Introduza o inicio : ");
        number_inicio = input.nextInt();
        System.out.print("Introduza o fim : ");
        number_fim = input.nextInt();

        for (number_referencia = number_inicio; number_referencia < number_fim; number_referencia++)
        {
            if ((number_referencia % 5) == 0 && number_referencia != number_inicio)
            {
                System.out.println("- " + number_referencia);
            }
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
