package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arrayUtilizador = new int[15];                                // array do utilizador
        int[] arrayPar = new int[0];                                        // array par final caso haja numeros pares
        int[] arrayImpar = new int[0];                                      // array impar final caso haja numeros impares

        for (int i = 0; i < arrayUtilizador.length; i++) {                  // leitura e introduçao dos numeros na array do utilizador
            System.out.print("Introduza um numero na array[" + i + "]:");
            arrayUtilizador[i] = input.nextInt();
        }

        for (int i = 0; i < arrayUtilizador.length; i++) {                  // ler a array do utilizador para ver os numeros pares ou impares
            boolean parOUnao = true;                                        // boleana para ajudar a inserir numeros nas arrays corretas
            if (arrayUtilizador[i] % 2 != 0)                                // se o numero for impar boleana fica falsa
                parOUnao = false;

            if (parOUnao) {                                                 // boleana verdadeira =  numero par
                int[] arrayTemp = new int[arrayPar.length + 1];             // criar uma array temporaria para inserior os numeros pares anteriores vistos mais o novo
                for (int k = 0; k < arrayTemp.length; k++) {                // ler a array temporaria para inserior os numeros pares
                    if (k == arrayTemp.length - 1)                          // se for a ultima posição insere o numero novo par
                        arrayTemp[k] = arrayUtilizador[i];
                    else
                        arrayTemp[k] = arrayPar[k];                         // se nao for a ultima posiçao adiciona os numeros pares todos
                }
                arrayPar = arrayTemp;
            } else {
                int[] arrayTemp = new int[arrayImpar.length + 1];           // mesma situação da array dos pares mas para os numeros impares (ler linha 23)
                for (int k = 0; k < arrayTemp.length; k++) {
                    if (k == arrayTemp.length - 1)
                        arrayTemp[k] = arrayUtilizador[i];
                    else
                        arrayTemp[k] = arrayImpar[k];
                }
                arrayImpar = arrayTemp;
            }
        }

        if (arrayPar.length > 0) {                              // leitura das arrays dos numeros pares e impares
            System.out.println("\n Os numeros pares são :");
            for (int i = 0; i < arrayPar.length; i++)
                System.out.println(arrayPar[i] + "\t");
        } else {
            System.out.println("Nao existe numeros pares");
        }
        if (arrayImpar.length > 0) {                            // leitura das arrays dos numeros pares e impares
            System.out.println("\n Os numeros impares são :");
            for (int i = 0; i < arrayImpar.length; i++)
                System.out.println(arrayImpar[i] + "\t");
        } else {
            System.out.println("Nao existe numeros impares!");
        }
    }
}
