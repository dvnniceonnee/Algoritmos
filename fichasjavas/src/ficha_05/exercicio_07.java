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
                parMaior = arrayNumeros[i];  // introduz o ultimo par da lista na variavel parMaior
                quantidadeNumerosPares++; // variavel para determinar se existem numeros pares
            }
        }
        if (quantidadeNumerosPares > 0) {  // se a quantidade de numeros pares for maior do que 0 vamos verficar qual é o par maior
            for (int i = 0; i < arrayNumeros.length; i++) {  // leitura da array
                if (arrayNumeros[i] % 2 == 0) {              // verifica se o numero é par
                    if (arrayNumeros[i] > parMaior) {        // verifica se é maior do que o parMaior anterior
                        parMaior = arrayNumeros[i];          // Caso seja introduz o numero na variavel parMaior
                    }
                }
            }
            System.out.println("O numero par maior é : " + parMaior);
        } else {
            System.out.println("Nao existe nenhum numero par!"); // como a quantidade de pares é 0 nao vamos verificar nada e vamos imprimir que não existem numeros pares
        }
    }
}
