package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        String numero_user;
        int lenghNum, contagem;

        // Ler variaveis
        System.out.println("<<<<< Programa de Numeros revertidos >>>>>\n");
        System.out.print("Introduza um numero : ");
        numero_user = input.next();

        for (lenghNum = numero_user.length(); lenghNum > 0 ; --lenghNum )
        {
            contagem = Character.getNumericValue(numero_user.charAt(lenghNum - 1));
            System.out.print(contagem);
        }
        System.out.println("\n\n<<<<< Fim de Programa >>>>>");
    }
}
