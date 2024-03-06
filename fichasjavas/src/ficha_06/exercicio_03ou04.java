package ficha_06;

import java.util.Scanner;

public class exercicio_03ou04 {
    public static boolean par (int num)
    {
        if (num % 2 == 0){
            return true;
        }
        else
            return false;
    }
    public static boolean positivo (int num) {
        if (num >= 0)
            return true;
        else
            return false;
    }

    public static boolean primo (int num)
    {
        boolean primoounao = true;
        for(int i = 2; i < num; i++)
        {
            if (num % i == 0)
            {
                primoounao = false;
            }
        }
        return primoounao;
    }

    public static boolean perfeito(int num)
    {
        boolean perfeitoounao;
        int soma = 0;
        for (int i = 1; i < num; i++ )
        {
            if (num % i == 0)
            {
                soma = soma + i;
            }
        }
        if (soma == num)
            return true;
        else
            return false;
    }

    public static boolean numerotriangulo (int num)
    {
        boolean triangulo = false;
        int soma = 0;
        for (int i = 1; i < num; i++)
        {
            soma = soma + i;
            if (num == soma)
            {
                triangulo = true;
                i = num;
            }
        }
        return triangulo;
    }

    public static void main(String[] args) {
        // Scanner
        Scanner input =  new Scanner(System.in);

        int opcao, numero;
        System.out.println("<<<<< Programa de funções >>>>>\n");

        System.out.print("Introduza um numero : ");
        numero = input.nextInt();

        do {
        System.out.println("\n\n1. Par ou Impar");
        System.out.println("2. Positivo ou Negativo");
        System.out.println("3. Primou ou Não Primo");
        System.out.println("4. Perfeito ou Não Perfeito");
        System.out.println("5. Triangular ou Não Triangular");
        System.out.println("6. Trocar de Numero");
        System.out.println("7. Sair");
        System.out.print("\nIntroduza a opção pretendida : ");
        opcao = input.nextInt();

        switch (opcao) {
            case 1:
                if (par(numero))
                    System.out.println("\nNumero " + numero + " é Par");
                else
                    System.out.println("\nNumero " + numero + " é Impar");
                break;
            case 2:
                if (positivo(numero))
                    System.out.println("\nNumero " + numero + " é positivo!");
                else
                    System.out.println("\nNumero " + numero + " é negativo");
                break;
            case 3:
                if (primo(numero))
                    System.out.println("\nNumero " + numero + " é Primo");
                else
                    System.out.println("\nNumero " + numero + " nao é Primo");
                break;
            case 4:
                if (perfeito(numero))
                    System.out.println("\nNumero " + numero + " é perfeito");
                else
                    System.out.println("\nNumero " + numero +  " não é perfeito");
                break;
            case 5:
                if (numerotriangulo(numero))
                    System.out.println("\nNumero "  + numero + " é triangular");
                else
                    System.out.println("\nNumero "  + numero + " nao é triangular");
                break;
            case 6:
                System.out.print("\nIntroduza um numero : ");
                numero = input.nextInt();
                break;
            case 7:
                numero = 0;
                break;
            default:
                System.out.println("Opção invalida!");

        }
        }while (numero > 0);
    }
}
