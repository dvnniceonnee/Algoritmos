package ficha_03;

import java.util.Scanner;

public class exercicio_14 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variaveis
        int number_utilizador, quantNumeros, saved_number = 0;
        boolean cresceBooleano = true;

        // Ler variaveis
        System.out.println("<<<<< Programa de ordens crescentes ou nao >>>>>\n");
        System.out.print("Quantos numeros deseja inserir : ");
        quantNumeros = input.nextInt();

        while (quantNumeros > 0)
        {
            System.out.print("Introduza um numero : ");
            number_utilizador = input.nextInt();
            if (number_utilizador > saved_number)
            {
                saved_number = number_utilizador;
                quantNumeros= --quantNumeros;
            }
            else
            {
                saved_number = number_utilizador;
                quantNumeros = --quantNumeros;
                cresceBooleano = false;
            }
        }
        if (cresceBooleano == false)
        {
            System.out.println("Nao é crescente!");
        }
        else
        {
            System.out.println("A ordem é crescente!");
        }
        System.out.println("\n <<<<< Fim de Progama >>>>>");
    }
}
