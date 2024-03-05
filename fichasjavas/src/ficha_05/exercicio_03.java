package ficha_05;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // declarar as variaveis
        int maiornum = 0,numero, quantNumeros = 0;
        int[] arrayNumeros =  new int[10];

        // Ler as variaveis
        do {
            System.out.println("Introduza um numero na array[" + quantNumeros + "] : ");
            numero =  input.nextInt();
            if (maiornum < numero)
            {

            }
            else {

            }
            ++ quantNumeros;
        }while (quantNumeros <= arrayNumeros.length);

    }
}
