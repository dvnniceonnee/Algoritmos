package extraFuncoes;

import java.util.Scanner;

public class exercicio_04 {
    public static void imprimirTabuada(int num)
    {
        System.out.println("\n");
        for(int i = 1; i <= 10; i++)
        {
            System.out.println(i + " x "+ num + " = " + (i*num));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Tabuadas para brincar >>>>>");
        System.out.print("Introduza o numero para a tabuada : ");
        imprimirTabuada(input.nextInt());
    }
}
