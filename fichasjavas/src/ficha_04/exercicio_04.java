package ficha_04;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        // IMportar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int num_utilizador, num_utilizador_helper, contagemNum_utilizador = 0;

        // Ler variaveis
        System.out.println("<<<<< Programa de numero primos >>>>>\n");
        System.out.print("Introduza um numero : ");
        num_utilizador = input.nextInt();

        while (num_utilizador < 1) { // Verificar se o numero é maior do que 1
            System.out.println("Numero invalido!!!\n");
            System.out.print("Introduza um numero : ");
            num_utilizador = input.nextInt();
        }
        num_utilizador_helper = num_utilizador;
        while (num_utilizador_helper > 0) { // Enquanto o numero ajudante for maior do 0 continuar a dividir o numero introduzido pelo utilizador para ver se é divisivel por mais do que um numero
            if (num_utilizador % num_utilizador_helper == 0) {
                ++contagemNum_utilizador; // Incrementa a quantidade de veze que o numero é divisel por outro numero
            }
            --num_utilizador_helper; // decrementa uma vez para depois dividir pelo proximo numero
        }
        if (contagemNum_utilizador > 2) { // Caso o numero seja divisivel por mais do que 2 numeros nao é primo
            System.out.println("O numero nao é primo !");
        } else { // Caso seja divisel por menos do que 2 numeros é primo
            System.out.println("O numero é primo!");
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");

    }
}
