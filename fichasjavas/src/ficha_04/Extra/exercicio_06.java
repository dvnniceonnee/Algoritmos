package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numeroUtilizador, maior_guardado , menor_guardado;

        // ler variaveis
        System.out.println("<<<<< Programa de Numeros maiors e menores >>>>>\n");
        System.out.print("Introduza um numero  : ");
        numeroUtilizador = input.nextInt();
        maior_guardado =  numeroUtilizador;
        menor_guardado =  numeroUtilizador;

        do {
            System.out.print("Introduza um numero  : ");
            numeroUtilizador = input.nextInt();
            if (numeroUtilizador < menor_guardado && numeroUtilizador != 0)
            {
                menor_guardado = numeroUtilizador;
            }
            else if (numeroUtilizador > maior_guardado)
            {
                maior_guardado = numeroUtilizador;
            }
        }while (numeroUtilizador != 0);

        System.out.println("Menor : " +  menor_guardado);
        System.out.println("Maior : " +  maior_guardado);
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
