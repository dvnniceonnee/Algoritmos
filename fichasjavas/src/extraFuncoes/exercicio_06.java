package extraFuncoes;

import java.util.Scanner;

public class exercicio_06 {
    public static int somatorio(int num) {
        int somaDigitos = 0;
        int numeroDivisor = 0;
        for (int i = 1; i > 0; i = i * 10) {
            if (num < i) {
                numeroDivisor = i / 10;
                i = -1;
            }
        }
        for (int i = numeroDivisor; i >= 1; i = i / 10) {
            if (num > 9) {
                somaDigitos = somaDigitos + (num / i);
                num = num % i;
            } else {
                somaDigitos = somaDigitos + num;
                i--;
            }

        }
        return somaDigitos;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<< Programa dos numeros >>>>\n");
        System.out.print("Introduza um numero : ");
        System.out.println("\nSomatório : " + somatorio(input.nextInt()));
    }
}
