package ficha_01;

import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Comentário para declarar variaveis
        int num1, num2, soma;
        System.out.println("Bom dia, siga la para mais uma aula!! ");
        // Ler num1
        // "sout" = abreviatura para introduzir a linha "System.out.println()"
        System.out.println("Insira um numero inteiro: ");
        num1 = input.nextInt();
        // Ler num2
        System.out.println("Insira um segundo numero inteiro: ");
        num2 = input.nextInt();

        // Somar num1 com num2
        soma = num1 + num2;

        // Apresentar resultado
        System.out.println("O resultado da soma é : " + soma);
    }
}
