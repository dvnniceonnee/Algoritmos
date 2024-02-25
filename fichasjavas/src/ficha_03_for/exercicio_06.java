package ficha_03_for;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variaveis
        int numero_limite, numero_inicio;

        // Ler as variaveis
        System.out.println("<<<<< Programa de numeros >>>>\n");
        System.out.print("Introduza um numero de inicio : ");
        numero_inicio = input.nextInt();
        System.out.print("Introduza um numero limite : ");
        numero_limite = input.nextInt();

        for (numero_inicio = numero_inicio; numero_inicio <= numero_limite;numero_inicio++) // Para o numero de inicio, enquanto nao for menor ou igual ao numero limite correr o codigo abaixo, e acrescentar um
        {
            System.out.println("- " + numero_inicio);
        }

        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
