package ficha_03_for;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        // IMportar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int number_of_times;
        String frase;

        // Ler as variaveis
        System.out.println("<<<<< Progama de repetiçoes >>>>>");
        System.out.print("Introduza quantas vezes quer ler a mensagem : ");
        number_of_times = input.nextInt();
        System.out.print("Introduza a mensagem : ");
        frase = input.next() + input.nextLine(); // Solucao encontrada pois nextLine() nao funciona por ela propria

        for (number_of_times = number_of_times; number_of_times > 0; number_of_times--) // Para o numero de vezes indicado, enquanto nao for 0, apresentar o codigo e diminui uma vez
        {
            System.out.println(frase);
        }

        System.out.println("<<<<< Fim de Programa >>>>>");
    }
}
