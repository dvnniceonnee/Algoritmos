package ficha_03;

import java.util.Scanner;

public class exercicio_15 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        long numero_utilizador, numero_fatorial; // Poderia usar um long mas mesmo assim seria um numero limitado


        // Ler as variaveis
        System.out.println("<<<<< Programa de numeros fatoriais >>>>>\n");
        System.out.print("Introduza um numero : ");
        numero_utilizador = input.nextInt();
        numero_fatorial = numero_utilizador;
        numero_utilizador = --numero_utilizador;

        while (numero_utilizador >= 1) { // Enquanto o calculo do fatorial nao acabar continuar o loop
            if (numero_fatorial >= 2147483647) {
                numero_utilizador = 0;
                numero_fatorial = 0;
            } else {
                numero_fatorial = numero_fatorial * numero_utilizador;
                --numero_utilizador;
            }
        }
        if (numero_fatorial == 0) {
            System.out.println("Numero introduzido para calculo de fatorial invalido!");
        } else {
            System.out.println("Fatorial : " + numero_fatorial);
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");

    }
}
