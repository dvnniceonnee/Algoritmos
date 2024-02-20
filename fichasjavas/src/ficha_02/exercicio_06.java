package ficha_02;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero1, numero2;

        System.out.println("Vamos aos numeros novamente !!");
        System.out.print("Introduza o primeiro numero : ");
        numero1 = input.nextInt();
        System.out.print("Introduza o segundo numero : ");
        numero2 = input.nextInt();

        if (numero1 > numero2) {
            System.out.println("Maior : " + numero1 + " Menor : " + numero2);
        } else {
            System.out.println("Maior : " + numero2 + " Menor" + numero1);
        }
    }
}
