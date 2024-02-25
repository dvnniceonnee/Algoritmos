package ficha_03;

import java.util.Scanner;

public class exercicio_11 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int number_limite, number_salto, number_apresentado = 0;

        // Ler variaveis
        System.out.println("<<<<< Programa de Whiles e numeros inteiros >>>>>");
        System.out.print("Introduza um limite : ");
        number_limite = input.nextInt();
        System.out.print("Introduza um salto : ");
        number_salto = input.nextInt();

        while (number_apresentado < number_limite) // Enquanto o numero que queremos apresentar nao chegar ao numero limite
        {
            System.out.println("- "+ number_apresentado); // Apresentar o numero
            number_apresentado =  number_apresentado + number_salto; // Incrementar o numero salto
        }

        System.out.println("\n<<<< Fim de Programa >>>>");
    }
}
