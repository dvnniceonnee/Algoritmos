package ficha_02;

import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numero1, numero2;

        // Ler Variaveis
        System.out.println("Ola, bom dia, vamos brincar com if's e else's");
        System.out.print("Insira um primeiro numero : ");
        numero1 = input.nextInt();
        System.out.print("Insira um segundo numero : ");
        numero2 = input.nextInt();

        // Verificar qual dos numeros é o menor e apresentar
        if (numero1 > numero2) {
            System.out.println("O maior numero é " + numero1);
        } else {
            if (numero2 > numero1) {
                System.out.println("O maior numero é " + numero2);
            } else {
                System.out.println("Os numeros são iguais!");
            }
        }


    }
}
