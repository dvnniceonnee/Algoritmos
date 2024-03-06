package ficha_05;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        int ordem;
        boolean crescent = true;
        int[] arrayNumeros = new int[10];

        // Ler as variaveis
        for (int i = 0; i < arrayNumeros.length; ++i) {
            System.out.print("Introduza um numero na array[" + i + "] : ");
            arrayNumeros[i] = input.nextInt();
        }
        ordem = arrayNumeros[0];
        for (int i = 1; i < arrayNumeros.length ; i++) // variavel local
        {
            if (ordem > arrayNumeros[i])
            {
                crescent = false;
                break; // como ja é falsa nao interessa verificar o resto :)
            }
        }
        if (crescent)
        {
            System.out.println("A ordem é crescente");
        }
        else
        {
            System.out.println("A ordem nao é crescente");
        }
    }
}
