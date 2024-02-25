package ficha_03;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numero_utilizador, contagemNumeros_inseridos = 1, media;

        // Ler variaveis
        System.out.println("<<<<< Programa de medias e whiles >>>>>");
        System.out.print("Introduza um numero : ");
        numero_utilizador = input.nextInt();
        media = numero_utilizador; // Atribui o primeiro numero à media para depois somar os outros numeros

        while (numero_utilizador != -1) // Enquanto nao por o numero pretendido (-1)
        {
            System.out.print("Numero Errado, Introduza um numero : "); // Pedir novamente outro numero
            numero_utilizador = input.nextInt(); // Ler o novo numero
            if (numero_utilizador != -1) // So incrementar caso nao seja o "-1"
            {
                contagemNumeros_inseridos = ++contagemNumeros_inseridos;
                media = media + numero_utilizador;
            }
        }
        media = media / contagemNumeros_inseridos;
        System.out.println(" - Media : " + media + "\n");
        System.out.println("<<<<< Fim de Programa >>>>>");
    }
}
