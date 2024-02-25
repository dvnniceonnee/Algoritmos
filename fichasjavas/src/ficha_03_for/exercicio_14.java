package ficha_03_for;

import java.util.Scanner;

public class exercicio_14 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int number_times, number, number_helper;
        boolean crescente = true;

        // Ler variaveis
        System.out.println("<<<<< Programa de ordem crescente ou nao >>>>>\n");
        System.out.print("Quantos numeros dejesa inserir : ");
        number_times = input.nextInt();
        System.out.print("Introduza um numero : ");
        number = input.nextInt();
        number_helper = number;

        for (number_times = number_times; number_times > 0; number_times--) {
            System.out.print("Introduza um numero : ");
            number = input.nextInt();
            if (number < number_helper) {
                crescente = false;
            }
            number_helper = number;
        }
        if (crescente == false) {
            System.out.println("Não é crescente");
        } else {
            System.out.println("É Crescente");
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
