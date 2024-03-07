package ficha_06;
import java.util.Scanner;

import static ficha_06.exercicio_05.*;

public class exercicio_06 {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);
        int tamanhoArray, opcao;


        System.out.println("<<<<< Programa de Arrays >>>>>\n");
        System.out.print("Introduza quantos numeros deseja inserir:");
        int[] arrayUtilizador = new int[input.nextInt()];

        for (int i = 0; i < arrayUtilizador.length; i++)
        {
            System.out.print("Introduza um valor no array[" + i +"]:");
            arrayUtilizador[i] =  input.nextInt();
        }

        do{
            System.out.println("\n1. Maior Elemento");
            System.out.println("2. Menor Elemento");
            System.out.println("3. Crescente ou Não crescente");
            System.out.println("4. Sair");
            System.out.print("\nIntroduza uma opção : \n");
            opcao = input.nextInt();

            switch (opcao)
            {
                case 1 :
                    System.out.println("O maior numero é : " + maiorNumero(arrayUtilizador));
                    break;
                case 2:
                    System.out.println("O menor numero é : " + menorNumero(arrayUtilizador));
                    break;
                case 3:
                    if (crescente(arrayUtilizador))
                        System.out.println("A ordem é crescente!");
                    else
                        System.out.println("A ordem não é crescente!");
                    break;
                case 4 :
                    System.out.println("\n <<<<<< Fim de Programa >>>>>");
                    break;
                default:
                    System.out.println("Opção Invalida!");
            }
        }while (opcao != 4);
    }
}
