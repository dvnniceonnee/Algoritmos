package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int num_user = 1, somatorio = 0, contagem = 0;
        String num_userstring;
        int numero;

        // Ler Variaveis
        System.out.println("<<<<< Programa de digitos >>>>>\n");
        System.out.print("Introduza um numero : ");
        num_userstring = input.next();
        num_user = num_userstring.length();

        for (contagem = contagem ; contagem < num_user ; ++contagem)
        {
            numero = Character.getNumericValue(num_userstring.charAt(contagem)); // Retira para um numero inteiro um caractere especifico de uma string com o index que quisermos
            System.out.print(numero + "+");
            somatorio = somatorio + numero ;
        }

        System.out.println("\nSoma : " + somatorio);
    }
}
