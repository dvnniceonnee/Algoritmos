package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de matrizes >>>>>\n");
        double[][] matriz = new double[3][3];

        for (int i = 0; i < matriz.length; i++) {                   // leitura dos numeros de cada matriz
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print("Introduza um numero na matriz[" + i + "][" + k + "]: ");
                matriz[i][k] = input.nextInt();
            }
        }
        System.out.println("\n");
        double maiorElemento = matriz[0][0], menorElemento = matriz[0][0]; // variaveis para armazenar o maior e o menor

        for (int i = 0; i < matriz.length; i++) {                   // leitura da matriz completa
            for (int k = 0; k < matriz[0].length; k++) {
                if (matriz[i][k] > maiorElemento)                   // verificar o maior numero da matriz
                    maiorElemento = matriz[i][k];
                else if (matriz[i][k] < menorElemento)              // verificar o menor numero da matriz
                    menorElemento = matriz[i][k];
            }
        }
        double segMaior, segMenor;                                  // variaveis para o segundo maior numero e o segundo menor numero (vairaveis definidas posteriormente como um numero de uma posicao da matriz porque se for 0 podem existir numeros negativos e o 0 vai ser o maior)

        if (matriz[0][0] == maiorElemento)                          // condicionais para caso o primeiro numero ser igual ao maior ou menos numero
            segMaior = matriz[0][1];                                // vairavel para armazenar um numero da matriz para posteriormente verificar qual o segundo maior
        else
            segMaior = matriz[0][0];
        if (matriz[0][0] == menorElemento)                          // condicional igual á linha 31
            segMenor = matriz[0][1];                                // vairavel para armazenar um numero da matriz para posteriormente verificar qual o segundo menor
        else
            segMenor = matriz[0][0];

        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                if (matriz[i][k] > segMaior && matriz[i][k] < maiorElemento)            // caso seja maior de todos mas menor do que o menor numero da matriz é o segundo maior
                    segMaior = matriz[i][k];
                else if (matriz[i][k] < segMenor && matriz[i][k] > menorElemento)       // caso seja menor de todos mas menor do que o maior numero da matriz é o segundo menor
                    segMenor = matriz[i][k];
                System.out.print(matriz[i][k] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("Segundo Maior : " + segMaior);
        System.out.println("Segundo Menor : " + segMenor);
    }
}
