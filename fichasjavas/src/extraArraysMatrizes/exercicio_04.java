package extraArraysMatrizes;
import java.util.Scanner;

import static extraArraysMatrizes.exercicio_03.existe;

public class exercicio_04 {
    public static void imprimirIndexCasoExista(int num, int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == num){
                System.out.println("Array["+ i + "]");
            }
        }
    }

    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        // variaveis
        int[] array = new int[10];
        int numero;

        // Ler os numeros para cada posicao do array
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("Introduza um numero no array[" + i +"]:");
            array[i] =  input.nextInt();
        }
        System.out.print("\nNumero a pesquisar : ");
        numero = input.nextInt();

        if (existe(numero, array))
            imprimirIndexCasoExista(numero, array);
        else
            System.out.println("O numero nao existe!");
    }
}
