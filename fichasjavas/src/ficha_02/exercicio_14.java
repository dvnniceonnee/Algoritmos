package ficha_02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class exercicio_14 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int num1, num2, num3;

        // Ler os numeros e inserir los nas variaveis
        System.out.println("Introduza 3 numeros aleatorios : ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();

        // verificar quais dos numeros é o maior e o menor
        // if (num1 < num2 && num1 < num3) {
        //     if (num2 < num3) {
        //         System.out.println("Os numeros por ordem crescente sao : " + num1 + " " + num3 + " " + num2);
        //     } else {
        //         System.out.println("Os numeros por ordem crescente sao : " + num1 + " " + num3 + " " + num2);
        //     }
        // } else {
        //     // num1 nao e o menor devido a condicao acima descrito na linha 20
        //     // Temos de verificar qual dos outros dois numeros e o menor e verificar se o numero 1 e menor do que o restante numero
        //     if (num2 < num3 && num1 < num3) {
        //         System.out.println("Os numeros por ordem crescente sao : " + num2 + " " + num1 + " " + num3);
        //     } else {
        //         if (num3 < num2 && num1 < num2) {
        //             System.out.println("Os numeros por ordem crescente sao : " + num3 + " " + num1 + " " + num2);
        //         }
        //         else
        //         {
        //             System.out.println("Os numeros por ordem crescente sao : "+ num3 + " " + num2 + " " + num1);
        //         }
        //     }
        // }

        if (num1 < num2 && num1 < num3 && num2 < num3) {
            System.out.println("Os numeros por ordem crescente sao : " + num1 + " " +  num2 + " " +  num3);
        } else {
            if (num2 < num3 && num3 < num1) {
                System.out.println("Os numeros por ordem crescente sao : " + num2 + " " + num3 + " " + num1);
            }
            else {
                if (num2 < num3 && num3 > num1){
                    System.out.println("Os numeros por ordem crescente sao : "+ num2 + " " + num1 + " " + num3);
                }
                else
                {
                    if (num3 < num2 && num2 < num1)
                    {
                        System.out.println("Os numeros por ordem crescente sao : " + num3 + " " + num2 + " " + num1);
                    }
                    else
                    {
                        System.out.println("Os numeros por ordem crescente sao : " + num3 + " " + num1 + " " + num2);
                    }
                }
            }
        }

    }
}
