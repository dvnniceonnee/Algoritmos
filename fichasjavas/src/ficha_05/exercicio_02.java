package ficha_05;

import java.util.Scanner;

public class exercicio_02 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input =  new Scanner(System.in);

        // Declarar as variaveis
        int mes = 1;
        double totalComissoes = 0;
        double[] arrayComissoes = new double[12];

        // ler as variaveis
        System.out.println("<<<<< Programa de arrays >>>>\n");

        do{
            System.out.print("Introduza a comissão para o mes (" + mes + ") : " );
            arrayComissoes[mes - 1] =  input.nextInt();
            mes++;
        }while (mes <= 12);

        for(mes = 1; mes <= 12; mes++)
        {
            totalComissoes = totalComissoes + arrayComissoes[mes -1];
        }
        System.out.println("O total de comissoes é : " +  totalComissoes);
    }
}
