package ficha_03;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variaveis
        int num_utilizador;
        String NewString;

        // Ler as variaveis
        System.out.println("<<<< Programa dos numeros inteiros >>>>>\n");
        System.out.print("Introduza quantas vezes quer ver a frase abaixo : ");
        num_utilizador = input.nextInt();
        System.out.print("\nIntroduza uma mensagem : ");
        NewString = input.next() + input.nextLine(); // Ler a proxima palavra e "nextLine" para ler os seguintes caracteres apos os espaços

        while (num_utilizador > 0) { // Enquanto o numero do utilizador nao for 0 continuar a escrever a frase
            System.out.println("- " + NewString);
            num_utilizador = --num_utilizador; // decremento ao numero de vezes que ja foi mostrado
        }

        System.out.println("\n<<<< Fim de Programa >>>>>");
    }
}
