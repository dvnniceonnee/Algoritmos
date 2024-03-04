package ficha_04;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int num_jogador1 = -1, num_jogador2 = -1, tentativas_jogador2 = 0;

        // Ler Variaveis
        System.out.println("<<<<< Jogo do Acerto >>>>\n");
        System.out.print("Jogador 1 introduza um numero (0-100) : ");
        num_jogador1 = input.nextInt();

        while (num_jogador1 < 0 || num_jogador1 > 100) {
            System.out.println("Jogador 1 valor introduzido nao é valido!");
            System.out.println("Introduza um numero entre 0 e 100");
            num_jogador1 = input.nextInt();
        }
        do {
            System.out.println("Jogador 2 adivinhe o numero  (0-100):"); // Pedir o numero ao jogador 2
            num_jogador2 = input.nextInt(); // Ler o numero introduzido pelo utilizador 2
            while (num_jogador2 < 0 || num_jogador2 > 100) // se nao for entre 0 e 100 nao é valido
            {
                System.out.println("Jogador 2 valor invalido!\n");
                System.out.println("Jogador 2 adivinhe o numero  (0-100):"); // Pedir o numero ao jogador 2
                num_jogador2 = input.nextInt();
            }
            if (num_jogador2 > num_jogador1) { // se for maior do que o valor do jogador 1 informa que está muito alto e incrementa uma tentativa
                ++tentativas_jogador2;
                System.out.println("Muito alto!\n");
            } else {
                if (num_jogador2 < num_jogador1) {
                    ++tentativas_jogador2;
                    System.out.println("Muito Baixo!");
                } else {
                    ++tentativas_jogador2;
                }
            }
        } while (num_jogador1 != num_jogador2);
        System.out.println("Acertou !!!!!!!");
        System.out.println("Tentou " + tentativas_jogador2 + " vezes!");
        System.out.println("\n <<<<< Fim de Progama >>>>>");
    }
}
