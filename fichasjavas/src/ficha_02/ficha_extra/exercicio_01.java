package ficha_02.ficha_extra;

import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int idade;

        // Ler a idade introduzida
        System.out.println("Vamos ver o quanto velho é !!");
        System.out.print("Introduza a sua idade : ");
        idade = input.nextInt();

        // verificar se a idade é maior do que 0 (caso nao seja não é valida)
        if (idade <= 0)
        {
            System.out.println("A sua idade não é valida!");
        }
        else
        {
            // verificar se é maior ou menor do que 18
            if (idade < 18)
            {
                System.out.println("Menor de idade");
            }
            else
            {
                System.out.println("Maior de idade");
            }
        }
    }
}
