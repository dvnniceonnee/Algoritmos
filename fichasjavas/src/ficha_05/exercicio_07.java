package ficha_05;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        int parMaior = 0, quantidadeNumerosPares = 0;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int i = 0; i < arrayNumeros.length; ++i) {
            System.out.print("Introduza um numero na array[" + i + "] : ");
            arrayNumeros[i] = input.nextInt();
            if (arrayNumeros[i] % 2 == 0) {
                parMaior = arrayNumeros[i];
                quantidadeNumerosPares++; // variavel para determinar se existem numeros pares
            }
        }
        if (quantidadeNumerosPares > 0) {
            for (int i = 0; i < arrayNumeros.length; i++) {
                if (arrayNumeros[i] % 2 == 0) {
                    if (arrayNumeros[i] > parMaior) {
                        parMaior = arrayNumeros[i];
                    }
                }
            }
            System.out.println("O numero par maior é : " + parMaior);
        } else {
            System.out.println("Nao existe nenhum numero par!");
        }
    }
}
