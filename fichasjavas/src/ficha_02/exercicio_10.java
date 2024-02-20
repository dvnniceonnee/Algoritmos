package ficha_02;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis para os 2 numeros reais e para a operacao aritmetica
        double numero1, numero2;
        String operArit;
        // Ler as variaveis
        System.out.println("Introduza dois numeros por favor : ");
        numero1 = input.nextDouble();
        numero2 = input.nextDouble();
        System.out.println("Introduza a operação pelo sinal da mesma a fazer : ");
        operArit = input.next();

        // Determinar qual operação realizar e apresentar o resultado
        switch (operArit){
            case "+" :
                System.out.println("O resultado da soma e " + (numero1 + numero2));
                break;
            case "-" :
                System.out.println("O resultado da subtraçao e " + (numero1 - numero2));
                break;
            case "*" :
                System.out.println("O resultado da multiplicacao e " + (numero1*numero2));
                break;
            case "/" :
                System.out.println("O resultado da divisao e " + (numero1/numero2));
                break;
            default:
                System.out.println("A operacao aritmetica desejada nao existe !!!");
        }
    }
}
