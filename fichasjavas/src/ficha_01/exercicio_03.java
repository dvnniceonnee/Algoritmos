package ficha_01;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int comp, larg, perimetro, area;

        System.out.println("Vamos brincar com retangulos !!");

        System.out.print("Introduza o comprimento do retangulo: ");
        comp = input.nextInt();

        System.out.print("Introduza a largura do retangulo:");
        larg = input.nextInt();

        perimetro = (larg+comp) * 2;
        System.out.println("O perimetro do retangulo é " + perimetro);

        area = larg * comp;
        System.out.println("A area do retangulo é " + area);

        System.out.println("Obrigado e até amanha!!");

    }
}
