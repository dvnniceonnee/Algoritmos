package ficha_05;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int num, max_num = 0;
        int[] arraynum = new int[10];

        // Ler as variaveis
        System.out.println("<<<<< Programa de array's >>>>>\n");

        do {
            System.out.print("Introduza um numero no array" + "[" + max_num + "] : ");
            arraynum[max_num] = input.nextInt();
            ++max_num;
        } while (max_num < 10);
        for (max_num = 0; max_num < 10; max_num++) {
            System.out.println(arraynum[max_num]);
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
