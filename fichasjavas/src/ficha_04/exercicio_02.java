package ficha_04;

import java.util.Scanner;

public class exercicio_02 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int opcaoEscolhida = 0;

        // Ler as variaveis
        System.out.println("<<<<< Programa de menus >>>>>\n");

        while (opcaoEscolhida != 4)
        {
            System.out.println("Escolha uma das seguintes opções : ");
            System.out.println("1 - Criar ");
            System.out.println("2 - Atualizar ");
            System.out.println("3 - Eliminar");
            System.out.println("4 - Sair");
            opcaoEscolhida = input.nextInt();
            switch (opcaoEscolhida)
            {
                case 1 :
                    System.out.println("A opção escolhida é Criar\n");
                    break;
                case 2 :
                    System.out.println("A opção escolhida é Atualizar\n");
                    break;
                case 3:
                    System.out.println("A opção escolhida é Eliminar\n");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nA opção escolhida nao é valida!\n");
            }
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
