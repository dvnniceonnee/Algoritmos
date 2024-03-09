package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arrayAjuda = new int[10];

        System.out.println("<<<<< Programa de arrays >>>>>\n");
        System.out.print("Quantos numeros deseja inserir no array : ");
        int[] array = new int[input.nextInt()]; // Array Inicial onde o utilizador vai introduzir os elementos com a quantidade desejada
        int[] arrayCrescente = new int[array.length]; // Array com os elementos da array inicial onde vai estar por ordem crescente


        for (int i = 0; i < array.length; i++) { // Ler os numeros a introduzir na array inicial
            System.out.print("Introduza um numero na array[" + i + "]:");
            array[i] = input.nextInt();
        }
        arrayAjuda = array; // Criei uma array de ajuda para depois jogar com ela

        for (int k = 0; k < arrayCrescente.length; k++) { // Loop para adicionar os elementos da array inicial por ordem crescente na arrayCrescente
            int numeroRemover = arrayAjuda[0]; // numero inicial da arrayAjuda para nao começar a 0 em caso se nao houver numeros negativos
            int[] arrayTemp = arrayAjuda; // criei uma array temporaria no loop para depois facilitar a remoçao de elementos
            for (int i = 1; i < arrayAjuda.length; i++) {
                if (arrayAjuda[i] < numeroRemover) {
                    numeroRemover = arrayAjuda[i]; // verificar qual o menor numero da array AJuda
                }
            }
            arrayAjuda = new int[arrayTemp.length - 1]; // modifiquei a array ajuda em tamanha pois vamos retirar o menor numero
            boolean removido = true; // boolean para saber se o numero a remover ja foi removido
            int contador = 0; // contador para ajudar no indice da array de ajuda

            for (int i = 0; i < arrayTemp.length; i++) {
                if (removido) { // se ja foi removido nao entra aqui
                    if (arrayTemp[i] == numeroRemover) {
                        removido = false; // significa que o numero que queremos remover foi removido e ja nao vai ser mais removido mesmo se ele for repetido
                    } else {
                        arrayAjuda[contador] = arrayTemp[i]; // a posiçao na arrayAJuda com o indice do contador vai conter os restantes elementos
                        contador++;
                    }
                } else {  // como ja foi removido é so adicionar os restantes numeros por ordem de inserção
                    arrayAjuda[contador] = arrayTemp[i];
                    contador++;
                }
            }
            arrayCrescente[k] = numeroRemover; // o numero que desejamos remover anteriormente vai ser o numero menor da arrayAjuda e vai ser adicionado á proxima posicao na arrayCrescente

        }
        for (int i = 0; i < arrayCrescente.length; i++) {
            System.out.print(arrayCrescente[i] + " "); // Impressao da arrayCrescente
        }
    }
}
