package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[12];
        int[] arraysemNumerosDup = new int[12];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Introduza um numero na array[" + i + "]:");
            array[i] = input.nextInt();
        }
        int contador = 0;
        int[] arrayajuda = new int[12];
        for (int i = 0; i < array.length; i++) {
            int numero_Dup = array[i];
            for (int k = i + 1; k < array.length; k++) {
                if (numero_Dup == array[k]) {
                    arrayajuda[contador] = numero_Dup;
                    contador++;
                    k = array.length;
                }
            }
        }
        for (int i= 0; i < arrayajuda.length; i++)
        {
            System.out.println(i + " : " +  arrayajuda[i] + " ");
        }
    }
}
