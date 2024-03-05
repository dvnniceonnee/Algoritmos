package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_0502 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int numeroExibido = 1, numeroContagem, basePiramide;

        // Ler variaveis
        System.out.println("<<<<< Programa de Piramides >>>>>\n");
        do{
            System.out.print("Introduza o numero de linhas que quer para a piramide (0-9): ");
            basePiramide = input.nextInt();
        }while(basePiramide > 9);

        basePiramide = (basePiramide * 2) - 1;

        for(numeroExibido = numeroExibido; numeroExibido <= (basePiramide + 1) /2 ; ++numeroExibido)
        {
            numeroContagem = (basePiramide - ((numeroExibido * 2)-1))/2;
            while (numeroContagem > 0){
                System.out.print(" ");
                --numeroContagem;
            }
            numeroContagem = (numeroExibido * 2) - 1;
            while (numeroContagem > 0){
                System.out.print(numeroExibido);
                --numeroContagem;
            }
            System.out.println();
        }
    }
}
