package extraFuncoes;

import java.util.Scanner;

public class exercicio_08 {
    public static boolean vogal(String palavra)
    {
        palavra = palavra.toLowerCase();
        switch (palavra)
        {
            case "a":
                return true;
            case "e":
                return true;
            case "i":
                return true;
            case "o":
                return true;
            case "u":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de Palavras >>>>>");

        System.out.print("Vamos verificar se a palavra é vogal : ");
        String letra = input.next();

        if (vogal(letra))
            System.out.println("\nA letra é vogal!");
        else
            System.out.println("\nA letra nao é vogal!");
    }
}
