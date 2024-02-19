package ficha_01;

import java.util.Scanner;

public class exercicio_02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Bom dia, vamos jogar com os numeros :)");

        int num1, num2, calc;

        // Ler e introduzir o primeiro numero
        System.out.print("Introduza o primeiro numero: ");
        num1 =  input.nextInt();

        // Ler e introduzir o segundo numero
        System.out.print("Introduza o segundo numero: ");
        num2 = input.nextInt();

        calc = num1 + num2;
        System.out.println("A soma destes numeros é: " + calc);

        calc = num1 - num2;
        System.out.println("A subtração destes numero é: " +  calc);

        calc = num1 * num2;
        System.out.println("A multiplicação destes numeros é: " + calc);

        calc = num1/num2;
        System.out.println("A divisão destes numeros é: "+ calc);
    }
}
