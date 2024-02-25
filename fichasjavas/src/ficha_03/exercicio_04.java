package ficha_03;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        // Importar o Scanner pois é necessario ler valores do utilizador
        Scanner input = new Scanner(System.in);

        //Declarar variaveis
        int num_utilizador, number = 0;

        System.out.println("<<<<< Programa de numeros inteiros >>>>>\n");
        System.out.print("Introduza um numero inteiro : ");
        num_utilizador = input.nextInt(); // Ler a variavel introduzida pelo utilizador

        while (number <= num_utilizador) //  Enquanto o numero for inferior ou igual ao numero do utilizador
        {
            System.out.println("- " + number); // Imprime o numero
            number = ++number; // Incrementa 1 para realizar o proximo loop
        }
        System.out.println("\n <<<<< Obrigado >>>>>");
    }
}
