package ficha_03;

import java.util.Scanner;

public class exercicio_14 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variaveis
        int number_utilizador, quantNumeros, saved_number;
        boolean cresceBooleano = true;

        // Ler variaveis
        System.out.println("<<<<< Programa de ordens crescentes ou nao >>>>>\n");
        System.out.print("Quantos numeros deseja inserir : ");
        quantNumeros = input.nextInt();
        System.out.print("Introduza um numero : ");
        number_utilizador = input.nextInt();

        while (quantNumeros > 1) {
            saved_number = number_utilizador;
            System.out.print("Introduza um numero : ");
            number_utilizador = input.nextInt();
            if (number_utilizador < saved_number) {
                cresceBooleano = false;
            }
            quantNumeros = --quantNumeros;
        }
        if (cresceBooleano == false) {
            System.out.println("Nao é crescente!");
        } else {
            System.out.println("A ordem é crescente!");
        }
        System.out.println("\n <<<<< Fim de Progama >>>>>");
    }
}
