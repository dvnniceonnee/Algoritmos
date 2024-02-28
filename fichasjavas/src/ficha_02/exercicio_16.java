package ficha_02;

import java.util.Scanner;

public class exercicio_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int montanteEuros, resto;

        // Ler o montante para atribuir a variavel
        System.out.println("Introduza o montante para ser dividido :");
        montanteEuros = input.nextInt();
        resto = montanteEuros;

        // Verificar se o montante é multiplo de 5
        if (montanteEuros % 5 == 0)
        {
            montanteEuros = resto / 200;
            System.out.println("Notas de 200 : " + montanteEuros);
            resto = resto % 200;

            montanteEuros = resto / 100;
            System.out.println("Notas de 100 : " + montanteEuros);
            resto = resto % 100;

            montanteEuros = resto / 50;
            System.out.println("Notas de 50 : " + montanteEuros);
            resto = resto % 50;

            montanteEuros = resto / 20;
            System.out.println("Notas de 20 : " + montanteEuros);
            resto = resto % 20;

            montanteEuros = resto / 10;
            System.out.println("Notas de 10 : " + montanteEuros);
            resto = resto % 10;

            montanteEuros = resto / 5;
            System.out.println("Notas de 5 : " + montanteEuros);
            resto = resto % 5;
        }
        else
        {
            System.out.println("Montante introduzido invalido!");
        }
    }
}
