package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arrayUtilizador = new int[12]; // array do uttilizador
        int[] arraySemRepetidos = new int[12];
        boolean existeRepetidos = false; // boleano para verificar se existem numeros repetidos

        for (int i = 0; i < arrayUtilizador.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            arrayUtilizador[i] = input.nextInt();
        }
        arraySemRepetidos =  arrayUtilizador;

        for (int i = 0; i < arraySemRepetidos.length; i++) {
            int numero_Dup = arraySemRepetidos[i];                       // numero da posiçao i da iteração
            boolean remove = false;                                     // boleano para posteriormente dizer se existe numeros duplicados para remover
            int contador = 0;                                           // contador para ajudar no tamanho das arrays
            for (int k = i + 1; k < arraySemRepetidos.length; k++) {     // o iterador começa na posição a seguir à posicao "i" para nao estar a verificar a mesma posição
                if (arraySemRepetidos[k] == numero_Dup) {                // caso o numero duplicado seja igual ao numero que estamos a verificar
                    remove = true;                                      // booleano para indicar se o numero está ducplicado
                    ++contador;                                         // contagem de numero de vezes que o numero está duplicado
                }
            }
            if (remove) {                                               // se for duplicado entra nesta condicional
                int[] arrayTemp = new int[arraySemRepetidos.length - contador]; // nova array com o tamanho correto (tamanho da original menos os numeros duplicados
                contador = 0;                                           // contador usado novamente e começa a 0
                boolean adicionar1 = true;
                for (int k = 0; k < arraySemRepetidos.length ; k++) {    // iterador para introduzir na nova lista menos os numeros duplicados
                    if (arraySemRepetidos[k] != numero_Dup) {            // se o numero for diferente ao numero duplicado acima adiciona por ordem como estava anteriomente
                        arrayTemp[contador] = arraySemRepetidos[k];
                        contador++;
                    } else {
                        if (adicionar1) {                               // condicional para adicionar apenas 1 vez o numero duplicado para ele ficar na lista na mesma
                            arrayTemp[contador] = arraySemRepetidos[k];
                            contador++;
                            adicionar1 = false;                         // trigger para nao deixar adicionar mais do que 1 vez
                        }
                    }
                }
                existeRepetidos = true;                                 //  booleana apenas para indicar se existe numeros duplicados na lista original
                arraySemRepetidos = arrayTemp;                           // lista nova sem o numeros duplicado para verificar se existe mais numeros duplicados
            }
        }

        if (existeRepetidos) {
            System.out.println("Existem " + (12 - arraySemRepetidos.length) + " numeros repetidos!\n");
        } else {
            System.out.println("Nao existem numeros repetidos!\n");
        }
        System.out.println("|||||| Array |||||");
        for (int i = 0; i < arraySemRepetidos.length; i++) {
            System.out.print(arraySemRepetidos[i] + "\t");
        }

    }
}
