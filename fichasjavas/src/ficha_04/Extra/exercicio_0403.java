package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_0403 {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int baseAsteriscos = 1, base_utilizador, contagemAjuda, numeroAsteriscos = 1;
        String asterisco = "*";

        // Ler variaveis
        System.out.print("Introduza a base para a piramide : "); // Pedir o numero de asteriscos para a base
        base_utilizador = input.nextInt();

        for (numeroAsteriscos = numeroAsteriscos; numeroAsteriscos <=base_utilizador; ++numeroAsteriscos )
        {
            if (numeroAsteriscos % 2 != 0)
            {
                baseAsteriscos = numeroAsteriscos;
                contagemAjuda = (base_utilizador - baseAsteriscos) /2;
                while (contagemAjuda > 0)
                {
                    System.out.print(" ");
                    --contagemAjuda;
                }
                while(baseAsteriscos > 0)
                {
                    System.out.print(asterisco);
                    --baseAsteriscos;
                }
                System.out.println();
            }
        }
    }
}
