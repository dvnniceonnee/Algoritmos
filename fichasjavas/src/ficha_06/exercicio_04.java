package ficha_06;
import java.util.Scanner;
import static ficha_06.exercicio_03.*;

public class exercicio_04 {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        int numero, opcao = 0;

        // Ler opcao do utilizador
        System.out.println("<<<<< Programa com funçoes >>>>>\n");
        System.out.print("Introduza um numero : ");
        numero = input.nextInt();

        do{
            System.out.println("\n1. Par ou Impar");
            System.out.println("2. Positivo ou Negativo");
            System.out.println("3. Primo ou nao Primo");
            System.out.println("4. Perfeito ou Nao Perfeito");
            System.out.println("5. Triangular ou Não Triangular");
            System.out.println("6. Trocar de Numero");
            System.out.println("7. Sair\n");
            opcao = input.nextInt();

            switch (opcao)
            {
                case 1 :
                    if (par(numero))
                        System.out.println("O numero " + numero + " é par!");
                    else
                        System.out.println("O numero " + numero + " é impar!");
                    break;
                case 2:
                    if (positivo(numero))
                        System.out.println("O numero " + numero + " é positivo!");
                    else
                        System.out.println("O numero " + numero + " é negativo!");
                    break;
                case 3:
                    if (primo(numero))
                        System.out.println("O numero " +  numero + " é primo!");
                    else
                        System.out.println("O numero " + numero + " nao é primo!");
                    break;
                case 4:
                    if (perfeito(numero))
                        System.out.println("O numero " + numero + " é perfeito!");
                    else
                        System.out.println("O numero " + numero + " nao é perfeito!");
                    break;
                case 5:
                    if (triangulo(numero))
                        System.out.println("O numero " + numero + " é triangular!");
                    else
                        System.out.println("O numero " + numero + " nao é triangular!");
                    break;
                case 6 :
                    System.out.print("Introduza um numero novo : ");
                    numero =  input.nextInt();
                    break;
                default:
                    System.out.println("\n <<<<<< Fim de Programa >>>>>>>>");
            }
        } while (opcao != 7);
    }
}
