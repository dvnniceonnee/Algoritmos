package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_0402 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // declarar variaveis
        int numero_linhas, contagem, maximoLinhas;

        // Ler as variaveis
        System.out.print("Introduza o numero de linhas desejadas : ");
        maximoLinhas = input.nextInt();

        for (numero_linhas = 1; numero_linhas <= maximoLinhas ; ++numero_linhas)
        {
            for (contagem = numero_linhas; contagem > 0; --contagem)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
