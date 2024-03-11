package extraFuncoes;

import java.util.Scanner;

public class exercicio_01 {
    public static int numeroMenor(int num1, int num2, int num3) {
        int numMenor;
        if (num1 < num2 && num1 < num3) {
                numMenor = num1;
        }
        else {
            if (num2 < num3)
                numMenor = num2;
            else
                numMenor = num3;
        }
        return numMenor;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de numeros pequenos >>>>");
        System.out.print("Introduza o numero 1 : ");
        int numero1 =  input.nextInt();
        System.out.print("Introduza o numero 2: ");
        int numero2 = input.nextInt();
        System.out.print("Introduza o numero 3: ");
        int numero3 = input.nextInt();

        System.out.println("O menor é : " + numeroMenor(numero1, numero2, numero3));
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
