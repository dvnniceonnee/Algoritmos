package ficha_03;

import java.util.Scanner;

public class exercicio_12 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numero_utilizador, intervalo_00_25 = 0, intervalo_26_50 = 0, intervalo_51_75 = 0, intervalo_76_100 = 0;

        // Ler variaveis
        System.out.println("<<<<< Programa de numeros e intervalos >>>>>\n");
        System.out.print("Introduza um numero (negativo termina o programa): ");
        numero_utilizador = input.nextInt();


        // Enquanto o numero for maior ou igual a "0" correr as condiçoes
        while (numero_utilizador >= 0) {
            if (numero_utilizador <= 25) { // caso seja menor do que 25 incrementar 1 ao intervalo definido
                intervalo_00_25 = ++intervalo_00_25;
                System.out.print("Introduza um numero : ");
                numero_utilizador = input.nextInt();
            } else {
                if (numero_utilizador <= 50) { // caso seja menor do que 25 incrementar 1 ao intervalo definido
                    intervalo_26_50 = ++intervalo_26_50;
                    System.out.print("Introduza um numero : ");
                    numero_utilizador = input.nextInt();
                } else {
                    if (numero_utilizador <= 75) { // caso seja menor do que 25 incrementar 1 ao intervalo definido
                        intervalo_51_75 = ++intervalo_51_75;
                        System.out.print("Introduza um numero : ");
                        numero_utilizador = input.nextInt();
                    } else {
                        if (numero_utilizador <= 100) { // caso seja menor do que 25 incrementar 1 ao intervalo definido
                            intervalo_76_100 = ++intervalo_76_100;
                            System.out.print("Introduza um numero : ");
                            numero_utilizador = input.nextInt();
                        }
                        else // Nao pertence a nenhum intervalo portanto apenas pede um novo numero e volta para cima
                        {
                            System.out.print("Introduza um numero : ");
                            numero_utilizador = input.nextInt();
                        }
                    }
                }
            }
        }
        // Apresentar os intervalos e quantos numeros entraram dentro deles
        System.out.println("[ 00 - 25 ] : " + intervalo_00_25);
        System.out.println("[ 26 - 50 ] : " +  intervalo_26_50);
        System.out.println("[ 51 - 75 ] : " + intervalo_51_75);
        System.out.println("[ 76 - 100 ] : " + intervalo_76_100);
        System.out.println("\n<<<<< Fim de Programa >>>>>\n");

    }
}
