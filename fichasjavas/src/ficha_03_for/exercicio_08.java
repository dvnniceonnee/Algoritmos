package ficha_03_for;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner  input = new Scanner(System.in);

        // Declarar as variaveis
        int number, numer_helper;

        // ler as variaveis
        System.out.println("<<<<< Programa de for's e numeros >>>>>\n");
        System.out.print("Introduza um numero : ");
        number = input.nextInt();
        numer_helper = number - 5;

        for (numer_helper = numer_helper; numer_helper <= (number + 5); numer_helper ++ )
        {
            if (numer_helper != number)
            {
                System.out.println("- " + numer_helper);
            }
            else
            {
                System.out.println("\n");
            }
        }

        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
