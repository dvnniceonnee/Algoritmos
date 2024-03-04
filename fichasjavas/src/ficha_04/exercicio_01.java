package ficha_04;

import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        double num1, num2, resultado;
        String opAritmetica, continuar = "s";

        // Ler Variaveis
        System.out.println("<<<<< Programa de Operaçõe Aritméticas >>>>\n");
        System.out.print("Introduza um numero : ");
        num1 = input.nextDouble();
        System.out.print("Introduza um segundo numero : ");
        num2 = input.nextDouble();


        do {
            System.out.println("Introduza a operação desejada ( + , - , / , *) : ");
            opAritmetica = input.next();
            switch (opAritmetica)
            {
                case "+" :
                    resultado = num1 + num2;
                    System.out.println("O somatório é : " + resultado);
                    break;
                case "-" :
                    resultado = num1 - num2;
                    System.out.println("A subtração é : " + resultado);
                    break;
                case "/" :
                    resultado = num1 / num2;
                    System.out.println("A divisão é : " + resultado);
                    break;
                case "*" :
                    resultado = num1 * num2;
                    System.out.println("A multiplicação é : " + resultado);
                    break;
                default:
                    System.out.println("A operação desejada nao é valida!");
            }
            System.out.print("Deseja continuar (s/n) : ");
            continuar = input.next();
        } while (continuar.equals("s"));
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
