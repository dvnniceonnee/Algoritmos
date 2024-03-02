package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numUser, nums_positive = 0, nums_negative = 0;

        // Ler variaveis
        System.out.println("<<<<< Programa de numeros positivos e negativos >>>>>\n");
        System.out.print("Introduza um numero : ");
        numUser =  input.nextInt();

        for (numUser = numUser; numUser !=0; numUser = input.nextInt())
        {
            if (numUser > 0)
            {
                ++nums_positive;
            }
            else {
                ++nums_negative;
            }
            System.out.print("Introduza um numero : ");
        }
        System.out.println("Positivos : " + nums_positive);
        System.out.println("Negativos : " +  nums_negative);
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}

