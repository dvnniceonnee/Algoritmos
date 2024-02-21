package ficha_02;

import java.util.Scanner;

public class exercicio_16 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int montanteEuros, notas;

        // Ler o montante para atribuir a variavel
        System.out.println("Introduza o montante para ser dividido :");
        montanteEuros = input.nextInt();

        // Verificar se o montante é multiplo de 5
        if (montanteEuros % 5 != 0 )
        {
            System.out.println("O montante introduzido nao é valido por nao ser multiplo de 5");
        }
        else
        {
            if (montanteEuros % 200 > 0)
            {
                if (montanteEuros % 200 > 0)
                {

                }
            }
            else
            {
                System.out.println("O montante selecionado pode ser decomposto em " + (montanteEuros / 200) + " de 200 euros");
            }
     }
    }
}
