package ficha_02;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numeroParouImpar;
        System.out.println("Vamos brincar com numeros pares e impares!");
        System.out.println("Introduza um numero para verificar se é par ou nao");
        numeroParouImpar = input.nextInt();

        if (numeroParouImpar%2 == 0)
            System.out.println("O numero é par");
        else
            System.out.println("O numero é impar");
    }
}
