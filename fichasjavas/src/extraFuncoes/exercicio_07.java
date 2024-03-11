package extraFuncoes;

import java.util.Scanner;

public class exercicio_07 {
    public static String inverterInteiro(int num) {
        int[] array = new int[2];
        int contadorzeros = 0;
        int numero = 0;
        int numeroDivisor = 0;
        for (int i = 1; i > 0; i = i * 10) {                        // verificar a casa decimal maior do numero para posteriormente começar a dividir lo
            if (num > 0) {
                if (num < i) {
                    numeroDivisor = i / 10;                         // como a maior casa decimal vai ser maior do que o numero vamos dividir por 10 para ficar na mesma casa decimal do numero
                    i = 0;                                          // i = 0 para teminar o loop
                }
            } else {
                if (num > (i) * -1) {
                    numeroDivisor = i / 10;                         // como a maior casa decimal vai ser maior do que o numero divido por 10 para ficar na mesma casa decimal do numero
                    i = 0;                                          // i = 0 para teminar o loop
                }
            }

        }
        for (int i = 1; i > 0; i = i * 10) {                    // i começa no 1 para multiplicar pela casa decimal trocada
            if (numeroDivisor == 1) {
                if (num == 0) {                                 // caso o numero seja 0 mas ainda nao tenha terminado vamos contar os "0"
                    contadorzeros++;
                } else {
                    numero = numero + ((num / numeroDivisor) * i); // se for 1 o ultimo numero vai multiplicar pela maior casa decimal e termina o loop
                }
                i = 0;
            } else {
                if (num == 0) {                                     // caso o numero a inverter tenha "0" no meio temos de os contar mas nao os podemos divir por nada
                    contadorzeros++;
                    numeroDivisor = numeroDivisor / 10;
                } else {
                    numero = numero + ((num / numeroDivisor) * i);  // determina qual o numero daquela posiçao e multiplica pela casa decimal correpondente para ficar na ordem
                    num = num % numeroDivisor;                      // o numero diminiu dividindo pelo i( que vai ser menos 1 casa decimal)
                    numeroDivisor = numeroDivisor / 10;             // o numerodivisor vai divindo por 10
                }
            }
        }
        String numApresentar = "";                                  // criado uma string para apresentar o numero pois um numero inteiro nao apresenta os numeros à esquerda
        if (numero < 0) {                                           // se o numero por negativo temos de ponderar os zeros caso existam pois o sinal de negativo vai ficar no meio do numero
            if (contadorzeros == 0) {
                numApresentar = String.valueOf(numero);             // como nao existem 0 vamos imprimir o numero normalmente
            } else {
                numApresentar += "-";                               // como existem 0 à esquerda do numero, vamos colocar o sinal de negativo antes dos 0
                for (int i = contadorzeros; i > 0; i--) {           // acrescentar os 0 todos a esquerda com um loop
                    numApresentar += "0";
                }
                numApresentar = numApresentar + String.valueOf(-numero);        // apresentar o numero negativo em positivo
            }
        } else {                                                    // mesma situaçao mas sem numeros negativos da linha 45
            if (contadorzeros == 0) {
                numApresentar = String.valueOf(numero);
            } else {
                for (int i = contadorzeros; i > 0; i--) {
                    numApresentar += "0";
                }
                numApresentar = numApresentar + String.valueOf(numero);
            }
        }
        return numApresentar;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de Numeros inversos >>>>>\n");
        System.out.print("Introduza um numero : ");
        int numero = input.nextInt();

        System.out.println(inverterInteiro(numero));

    }
}
