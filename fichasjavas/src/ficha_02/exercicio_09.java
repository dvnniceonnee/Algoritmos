package ficha_02;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar os 3 numeros
        int numero1, numero2, numero3;
        // Ler os 3 numeros & obter o menor numero
        System.out.println("Introduza o primeiro numero");
        numero1 = input.nextInt();
        numero2 = input.nextInt();
        numero3 = input.nextInt();

        // Verificar quais dos numeros é o menor com condicionais
        if (numero1 < numero2 && numero1 < numero3) {
            System.out.println("O menor numero é o " + numero1);
        }
        else {
            if (numero2 < numero3){
                System.out.println("O menor numero é o " + numero2);
            }
            else
                System.out.println("O menor numero é o " + numero3);
        }


    }
}
