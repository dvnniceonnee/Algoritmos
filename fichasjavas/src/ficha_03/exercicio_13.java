package ficha_03;

import java.util.Scanner;

public class exercicio_13 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int numero_limite, numero_inicio;

        // Ler Variaveis
        System.out.println("<<<<< Programa de muliplos de 5 >>>>>\n");
        System.out.print("Introduza o Inicio : ");
        numero_inicio = input.nextInt();
        System.out.print("Introduza o limite : ");
        numero_limite = input.nextInt();
        numero_inicio = ++numero_inicio; // Incremento para nao apresentar o numero de inicio caso ele seja multiplo de 5

        while (numero_inicio < numero_limite) // Enquanto o numero de inicio for menor do que o numero limite introduzido continuar a condiçao
        {
            if ((numero_inicio % 5) == 0) // Se o numero for multiplo de 5 apresentar senao continua
            {
                System.out.println(" " + numero_inicio);
            }
            ++numero_inicio; // incremento para o proximo loop
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
