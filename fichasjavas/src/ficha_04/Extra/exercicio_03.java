package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {

        // Declarar variaveis
        int numero_tabuada, contagem_tabuada = 1;

        for (numero_tabuada = 1; numero_tabuada <=10; ++numero_tabuada )
        {
            System.out.println("\nTabudada do " + numero_tabuada + " :");
            while (contagem_tabuada <= 10)
            {
                System.out.println(numero_tabuada + " x " + contagem_tabuada + " = " + numero_tabuada*contagem_tabuada);
                ++contagem_tabuada;
            }
            contagem_tabuada = 1;
        }

    }
}
