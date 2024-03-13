package ficha_07;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        int[] numeros = {5, 1, 2, 3, 4, 5, 17, 19};
        int[] divisores = {6, 0, 6, 0, 9, 10};

        Scanner input = new Scanner(System.in);
/*
        for (int i = 0; i < numeros.length; i++) {
            try {
                System.out.println("Divisão " + i);
                System.out.println("Divisao :" + numeros[i] / divisores[i]);

            } catch (ArithmeticException ex1) {
                System.out.println("Divisão impossivel!");
            }
            catch (IndexOutOfBoundsException ex2)
            {
                System.out.println("Elemento nao encontado!");
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Divisão " + i);
            System.out.println("Divisao :" + numeros[i] / divisores[i]);
            System.out.println("Elemento nao encontado!");
        }
        */

    }
}

class MinhaExcepcao extends Exception {
    MinhaExcepcao(int num) {
        try {
            int numero = num;
        } catch (InputMismatchException ex1) {
            System.out.println("Numero invalido!");
        }
    }
}
