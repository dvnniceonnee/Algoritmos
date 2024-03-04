package ficha_03;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        double numero_utilizador, contagemNumeros_inseridos = 0, media = 0;

        // Ler variaveis
        System.out.println("<<<<< Programa de medias e whiles >>>>>");
        System.out.print("Introduza um numero : ");
        numero_utilizador = input.nextDouble();// Atribui o primeiro numero à media para depois somar os outros numeros

        while (numero_utilizador >= 0) // Enquanto nao por o numero pretendido (-1)
        {
            contagemNumeros_inseridos++;
            media = media + numero_utilizador;
            System.out.print("Introduza um numero : "); // Pedir novamente outro numero
            numero_utilizador = input.nextDouble(); // Ler o novo numero
        }
        media = media / contagemNumeros_inseridos;
        System.out.println(" - Media : " + media + "\n");
        System.out.println("<<<<< Fim de Programa >>>>>");
    }
}
