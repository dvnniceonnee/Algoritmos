package ficha_02.ficha_extra;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variaveis
        int ano, ano_referencia = 2000;

        // Ler variaveis
        System.out.println("Vamos brincar com anos bissextos!");
        System.out.print("Introduza o ano que deseja verificar se é ou nao bissexto : ");
        ano = input.nextInt();

        // verificar se o ano é valido
        if (ano < 0)
        {
            System.out.println("O ano introduzido nao é valido!");
        }
        // Atribuir um ano de referencia
        // Verificar se o ano subtraido pelo ano de referencia(obrigatorio ser 1 ano bissexto) a dividir por 4 dá resto "0"
        // Caso de 0 apresentar que é bisexto
        else
        {
            if (ano > ano_referencia)
            {
                ano_referencia = ano - ano_referencia;
                if ((ano % 4) == 0 )
                {
                    System.out.println("O ano de " + ano + " é Bissexto.");
                }
                else
                {
                    System.out.println("O ano de " + ano + " nao é Bissexto.");
                }
            }
            else
            {
                ano_referencia = ano_referencia - ano;
                if ((ano % 4) == 0 )
                {
                    System.out.println("O ano de " + ano + " é Bissexto.");
                }
                else
                {
                    System.out.println("O ano de " + ano + " nao é Bissexto.");
                }
            }
        }
    }
}
