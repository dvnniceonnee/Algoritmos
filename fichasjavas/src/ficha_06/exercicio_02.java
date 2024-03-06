package ficha_06;

import java.util.Scanner;

public class exercicio_02 {
    public static String numeroAsteriscos (int a)
    {
        String asteriscos = "";
        for (int i = 1; i <= a; i++ )
        {
            asteriscos = asteriscos + "*";
        }
        return asteriscos;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalAsteriscos = 0;

        do {
            System.out.print("Introduza um numero : ");
            totalAsteriscos = input.nextInt();
        }while (totalAsteriscos < 0);

        System.out.println(numeroAsteriscos(totalAsteriscos));
        System.out.println("\n<<<<< Fm de rograma ");
    }
}
