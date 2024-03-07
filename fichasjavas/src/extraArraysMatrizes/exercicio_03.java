package extraArraysMatrizes;

import java.util.Scanner;

public class exercicio_03 {
    public static boolean existe (int num, int[] array)
    {
        boolean numExiste = false;
        for (int i = 0; i < array.length; i++) // iterar o array
        {
            if (num == array[i]) // verificar se algum numero é igual a um numero do array
            {
                numExiste = true;
            }
        }
        return numExiste;
    }
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        // variaveis
        int[] array = new int[10];

        // Ler os numeros para cada posicao do array
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("Introduza um numero no array[" + i +"]:");
            array[i] =  input.nextInt();
        }

        System.out.print("\nNumero a pesquisar : ");
        int numero = input.nextInt();

        if (existe(numero, array))
            System.out.println(numero + " existe no Array");
        else
            System.out.println(numero + " nao existe no array");
    }
}
