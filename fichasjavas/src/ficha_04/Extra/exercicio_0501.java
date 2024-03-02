package ficha_04.Extra;

import java.util.Scanner;

public class exercicio_0501 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numerolimite, numeroExibido , numeroContagem = 1;

        //Ler variaveis
        System.out.println("<<<<< Programa de piramides >>>>\n");
        System.out.print("Introduza um numero limite para a base da piramide : ");
        numerolimite = input.nextInt();

        for(numeroContagem = numeroContagem; numeroContagem <= numerolimite && numeroContagem <= 9; numeroContagem++) // para o numero de contagem que começa em 1 e termina no numero limite introduzido
            // maximo numero 9 que pode ser introduzido, pois dois digitos ocupa mais espeço
        {
            numeroExibido = numeroContagem; // numeros de vezes que o numero vai ser mostrado
            while (numeroExibido > 0) // enquanto o numero de vezes nao for 0 continua a mostrar
            {
                    System.out.print(numeroContagem + " ");
                    --numeroExibido;
            }
            System.out.println();
        }
        System.out.println("...");
    }
}
