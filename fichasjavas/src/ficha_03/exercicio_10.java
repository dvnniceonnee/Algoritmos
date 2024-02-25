package ficha_03;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int number_utilizador, numberApresentado = 2;

        // Ler variaveis
        System.out.println("<<<<< Programa numeros pares e inteiros >>>>>\n");
        System.out.print("Introduza um numero :");
        number_utilizador = input.nextInt();

        // Verificar se o numero ainda esta dentro do intervalo entre o 2 e o numero introduzido
        while (numberApresentado >= 2 && numberApresentado <= number_utilizador)
        {
            if (numberApresentado % 2 == 0) { // Verificar se o numero a apresentar é par
                System.out.println("- " + numberApresentado);
                numberApresentado = ++numberApresentado;
            }
            else // Caso nao seja par apenas incrementar para verificar o numero no proximo loop
            {
                numberApresentado = ++numberApresentado;
            }
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
