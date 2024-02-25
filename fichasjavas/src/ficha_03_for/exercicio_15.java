package ficha_03_for;

import java.util.Scanner;

public class exercicio_15 {
    public static void main(String[] args) {
        // Importar Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        long numero, numero_referencia, calculo = 0;

        // Ler variaveis
        System.out.println("<<<<< Programa de fatoriais >>>>>\n");
        System.out.println("Introduza um numero : ");
        numero = input.nextInt();
        numero_referencia = numero - 1;
        calculo = numero;

        for (numero_referencia = numero_referencia; numero_referencia > 0; numero_referencia--) {
            if (calculo < 2147483647) {
                calculo = calculo * numero_referencia;
            } else {
                calculo = 0;
                numero_referencia = 0;
            }
        }
        System.out.println("Fatorial de " + numero + " : " + calculo);
    }
}
