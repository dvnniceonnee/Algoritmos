package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int num1_user, num2_expo, num_final = 1;

        // Ler variaveis
        System.out.println("<<<<< Programa de exponenciais >>>>>\n");
        System.out.print("Introduza um numero : ");
        num1_user =  input.nextInt();
        System.out.println("Introduza um exponecial para esse numero : ");
        num2_expo =  input.nextInt();

        for (num2_expo = num2_expo; num2_expo > 0 ; --num2_expo)
        {
            num_final = num_final * num1_user;
        }

        System.out.println("O resultado de " +  num1_user + " elevado a " +  num2_expo + " : " +  num_final);
    }
}
