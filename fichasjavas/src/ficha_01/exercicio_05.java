package ficha_01;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double nota1, nota2, nota3, media;

        System.out.println("Bom dia, vamos ás medias !!");

        System.out.print("Introduza a primeira nota: ");
        nota1 = input.nextDouble();
        System.out.print("Introduza a segunda nota: ");
        nota2 = input.nextDouble();
        System.out.print("Introduza a terceira nota : ");
        nota3 = input.nextDouble();

        //Apresentar notas
        System.out.println("A notas por ordem são " + " " + nota1 + " " + nota2 + " " + nota3);
        media = (nota1 + nota2 + nota3)/3;

        // Apresentar as medias
        // "\n" = Salto de linha ou seja linebreak
        System.out.println("A médias destas 3 notas são : " + media);

        media = (nota1 * 0.2)+(nota2 * 0.3)+(nota3 * 0.5);
        System.out.println("A media ponderada é " + media);

    }
}
