package ficha_02.ficha_extra;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        double preco;

        // Ler variaveis
        System.out.print("Introduza o preço do produto : ");
        preco = input.nextDouble();

        // Verificar se o preço é maior do que 0
        if (preco < 0)
        {
            System.out.println("O preço introduzido nao é valido");
        }
        else
        {
            // Verificar se o preço é menor do que 100 para nao aplicar produto
            if (preco < 100)
            {
                System.out.println("Preço Final : " + preco + " (S/desconto)");
            }
            // Caso seja maior do que 100, aplicar 10% de desconto
            else
            {
                preco = preco * 0.9;
                System.out.println("Preço Final : " + preco + " (c/10% de Desconto)");
            }
        }
    }
}
