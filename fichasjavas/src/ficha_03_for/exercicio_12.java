package ficha_03_for;

import java.util.Scanner;

public class exercicio_12 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int number, intervalo_0025 = 0, intervalo_2550 = 0, intervalo_5175 = 0, intervalo_76100 = 0;

        // Ler as variaveis
        System.out.println("<<<<< Programa de intervalos >>>>>\n");
        System.out.print("Introduza um numero : ");
        number = input.nextInt();

        for (number = number; number > 0; number = input.nextInt()) {
            if (number <= 25) {
                intervalo_0025 = ++intervalo_0025;
            } else {
                if (number <= 50) {
                    intervalo_2550 = ++intervalo_2550;
                } else {
                    if (number <= 75) {
                        intervalo_5175 = ++intervalo_5175;
                    } else {
                        if (number <= 100) {
                            intervalo_76100 = ++intervalo_76100;
                        }
                    }
                }
            }
            System.out.print("Introduza um numero : ");
        }
        System.out.println(" [00 - 25 ] : " + intervalo_0025);
        System.out.println(" [26 - 50 ] : " + intervalo_2550);
        System.out.println(" [51 - 75 ] : " + intervalo_5175);
        System.out.println(" [76 - 100 ] : " + intervalo_76100);
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
