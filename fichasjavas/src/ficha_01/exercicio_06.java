package ficha_01;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int valor1, valor2;

        System.out.println("Bom dia, vamos comer o cerebro !!");

        System.out.print("Introduza um valor: ");
        valor1 = input.nextInt();
        System.out.println("Introduza um segundo valor: ");
        valor2 = input.nextInt();

        System.out.println("Os valores apresentados são: " + valor1 + " " + valor2);
        valor1 = valor1 + valor2;
        valor2 = valor1 - valor2;
        valor1 = valor1 - valor2;

        System.out.println("Os valores trocados 1 pelo outro são: " +  valor1 + " " + valor2);

        System.out.println("Obrigado");
    }
}
