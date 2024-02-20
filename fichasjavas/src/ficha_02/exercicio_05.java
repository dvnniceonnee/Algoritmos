package ficha_02;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero1, numero2;

        System.out.println("Vamos brincar com numeros novamente!");
        System.out.println("Introduza o primeiro numero : ");
        numero1 = input.nextInt();
        System.out.println("Introduza um segundo numero : ");
        numero2 = input.nextInt();

        if (numero1 > numero2)
        {
            System.out.println("Menor : " + numero2 + " -- Maior : " +  numero1);
        }
        else
        {
            System.out.println("Menor : " + numero1 + " --  Maior : " +  numero2);
        }
    }
}
