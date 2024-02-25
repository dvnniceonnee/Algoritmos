package ficha_03_for;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int numero, media = 0, quant_numeros = 0;

        // Ler as variaveis
        System.out.println("<<<<< Progama de medias >>>>>\n");
        System.out.print("Introduza um numero : ");
        numero = input.nextInt();

        for (numero = numero; numero >= 0 ; quant_numeros++) // Para o numero, enquanto for maior do 0, correr o codigo abaixo e acrescentar um á quantidade de numeros
        {
            media = media + numero; // soma de todos os numeros introduzidos
            System.out.print("Introduza um numero : ");
            numero = input.nextInt(); // Pedir outro numero
        }
        System.out.println("Media  : " + media/quant_numeros);
        System.out.println("\n <<<< Fim de Programa >>>>>");
    }
}
