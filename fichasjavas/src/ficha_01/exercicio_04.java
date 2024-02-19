package ficha_01;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ola bom dia, vamos ás rodinhas!!");

        double raio, area, pi = 3.1415;

        System.out.println("Introduza o raio da cincunferencia: ");
        raio = input.nextInt();
        area = pi * (raio * raio);
        System.out.println("A area da circunferencia é: " + area );

        System.out.println("Obrigado mais ou vez");


    }
}
