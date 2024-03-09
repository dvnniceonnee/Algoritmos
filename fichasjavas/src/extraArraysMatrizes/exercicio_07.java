package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de arrays >>>>>\n");
        System.out.print("Quantos numeros deseja inserir no array : ");
        int[] array = new int[input.nextInt()];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            array[i] = input.nextInt();
        }
        System.out.println();

        System.out.println("Qual o numero que quer remover? : ");
        int numeroRemover = input.nextInt();
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroRemover) { // se o numero a remover for igual a um dos numeros da array
                contador++; // saber quantas vezes temos de remover o numero
            }
        }

        if (contador > 0) {                                    // se o contador for maior do que 0 significa que há um numero de vezes a remover um numero
            int[] newArray = new int[array.length - contador]; // o tamanho da array vai ser o tamanho da array original menos as vezes do numero de vezes do numero a remover
            contador = 0; //
            for (int i = 0; i < array.length; i++) {
                if (array[i] != numeroRemover) {               // se o numero da array for diferente do numero a remover adiciona o numero
                    newArray[contador] = array[i];
                    contador++;                                // adiciona a proxima posicao a adicionar o proximo numero que nao seja o numero a remover para dar skip
                }
            }
            for (int i = 0; i < newArray.length; i++)
            {
                System.out.print("Array[" + i + "]: " + newArray[i] + " ");
            }
            System.out.println();
        }else {

            System.out.println("Nao existe esse numero a remover!");
        }
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
