package extraFuncoes;

import java.util.Scanner;

public class exercicio_02 {
    public static double mediaArit(int num1, int num2, int num3)
    {
        double media;
        media = (num1 + num2 + num3) /3;
        return media;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de media >>>>>\n");
        System.out.print("Introduza o numero 1: ");
        int numero1 = input.nextInt();
        System.out.print("Introduza o numero 2: ");
        int numero2 =  input.nextInt();
        System.out.print("Introduza o numero 3: ");
        int numero3 = input.nextInt();

        System.out.println("A media é : " + mediaArit(numero1, numero2, numero3));
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
