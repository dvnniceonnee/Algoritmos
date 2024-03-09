package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array1 = new int[8];           // array 1
        int[] array2 = new int[8];           // array 2
        int[] arrayNova = new int[0];        // array com os valores duplicados

        for (int k = 0; k < array1.length; k++) {     // leitura da array1
            System.out.print("Introduza um numero na array1[" + k + "] :");
            array1[k] = input.nextInt();
        }
        System.out.println();
        for (int k = 0; k < array2.length; k++) {    // leitura da array2
            System.out.print("Introduza um numero na array1[" + k + "] :");
            array2[k] = input.nextInt();
        }
        int contador = 0;       // contador de ajuda para saber quantos numeros iguais o array novo ja tem (podemos trocar por uma variavel boleana)

        for (int i = 0; i < array1.length; i++) {               // ler os elementos da array1
            for (int u = 0; u < array2.length; u++) {           // ler os elemntos da array2
                if (array2[u] == array1[i]) {                   // caso o elemento da array1 com o indice "i" seja igual ao elemento da array2 com o indice "u"
                    if (contador > 0) {                         // se  existir algum numero na lista dos numeros iguais realiza a condiçao abaixo
                        for (int k = 0; k < arrayNova.length; k++) {        // ler o array dos numeros iguais
                            if (array1[i] == arrayNova[k]) {                // se o numero ja existir na array nova dos numeros iguais nao entra novamente
                                k = arrayNova.length;                       // fecha os dois ciclos anteriores
                                u = array2.length;
                            } else {                                        // caso nao exista ainda no array novo adiciona
                                int[] arrayTemp = new int[arrayNova.length + 1];        // criação de um novo array para ficar com o tamanho correto
                                for (int p = 0; p < arrayTemp.length; p++) {            // introduzir o array novo neste temporario para conseguir adicionar o novo numero
                                    if (p == arrayTemp.length - 1) {                    // caso seja a ultima posicao é para adicionar o numero novo
                                        arrayTemp[p] = array1[i];
                                    } else {                                            // replicação dos numeros do arrayNova no arrayTemp com a exceção que o numero novo vai ser adicionado na ultima posição
                                        arrayTemp[p] = arrayNova[p];
                                    }
                                }
                                contador++;                                 // adiciona uma vez ao contador
                                arrayNova = arrayTemp;                      // a arrayNova fica igual ao arrayTemp com mais uma posição
                                k = arrayNova.length;                       // termina os dois ultimos ciclos automaticamente porque ja foi adicionado um numero
                                u = array2.length;
                            }
                        }
                    } else {                                                // caso nao existe numeros no arrayNova vamos adicionar logo este sem verificaçoes
                        int[] arrayTemp = new int[arrayNova.length + 1];    // array com tamanho correto
                        for (int k = 0; k < arrayTemp.length; k++) {        // adicionar o numero logo de seguida
                            arrayTemp[k] = array1[i];
                        }
                        contador++;
                        u = array2.length;
                        arrayNova = arrayTemp;
                    }
                }
            }
        }
        if (contador > 0) {
            System.out.println("Array com os valores iguais presentes nas duas arrays iniciais : \n");
            for (int i = 0; i < arrayNova.length; i++) {
                System.out.print(arrayNova[i] + " ");
            }
        } else
            System.out.println("Nao existem valores iguais presentes nas duas arrays iniciais!");
    }
}
