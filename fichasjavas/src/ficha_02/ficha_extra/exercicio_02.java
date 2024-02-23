package ficha_02.ficha_extra;

import java.sql.SQLOutput;
import java.util.Scanner;

public class exercicio_02 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        double peso;

        // Ler as variaveis
        System.out.println("Vamos verificar se é gordo!");
        System.out.print("Introduza o seu peso em Kg : ");
        peso = input.nextDouble();

        // Verificar se o peso introduzido é maior do que 0
        if (peso < 0 )
        {
            System.out.println("O peso introduzido não é valido!");
        }
        else
        {
            // Calcular o peso caso seja maior do que 0 por 0.16 (16% na lua do peso da Terra)
            // Apresentar o resultado
            peso = peso * 0.16;
            System.out.println("O seu peso na Lua é : " + peso + " Kg");
        }
    }
}
