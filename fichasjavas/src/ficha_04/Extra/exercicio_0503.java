package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_0503 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int numeroExibido = 1, numeroContagem, basePiramide;
        String numeraApresentar = "1";

        // Ler variaveis
        System.out.println("<<<<< Programa de Piramides >>>>>\n");
        System.out.print("Introduza o numero de linhas que quer para a piramide: ");
        basePiramide = input.nextInt();

        while (basePiramide > 9)
        {
            System.out.print("Introduza um numero de novo (1 até 9) : ");
            basePiramide = input.nextInt();
        }
        basePiramide = (basePiramide * 2) - 1;

        for(numeroExibido = numeroExibido; numeroExibido <= (basePiramide + 1) /2 ; ++numeroExibido)
        {
            numeroContagem = (basePiramide - ((numeroExibido * 2)-1))/2;
            while (numeroContagem > 0){
                System.out.print(" ");
                --numeroContagem;
            }
            // if (numeroExibido > 1)
            //{
            //    numeraApresentar =  numeroExibido + numeraApresentar + numeroExibido;
            // }
            numeroContagem = numeroExibido;
            while (numeroContagem > 1)
            {
                System.out.print(numeroContagem);
                --numeroContagem;
            }
            do
            {
                System.out.print(numeroContagem);
                ++numeroContagem;
            }while(numeroContagem <= numeroExibido);
            System.out.println();
        }
    }
}
