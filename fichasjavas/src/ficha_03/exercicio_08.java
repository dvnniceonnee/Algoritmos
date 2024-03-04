package ficha_03;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int number, numberApresentado;

        // Ler variaveis
        System.out.println("<<<<< Programa de numeros inteiros >>>>>\n");
        System.out.print("Introduza um numero : ");
        number = input.nextInt();
        numberApresentado = number - 5; // Atribuir o menor valor para depois incrementar

        while (numberApresentado <= (number + 5)) // verificar se o valor menos 5 e mais 5 ainda esta dentro dos intervalos
        {
            if (numberApresentado == number) // caso seja o proprio numero indicado nao apresentar
            {
                System.out.println(); // Imprimir uma linha
            } else{
                System.out.println("- " + numberApresentado); // Apresentar o numero
            }
            numberApresentado = ++numberApresentado; // Incrementa um para continuar para o próximo
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
