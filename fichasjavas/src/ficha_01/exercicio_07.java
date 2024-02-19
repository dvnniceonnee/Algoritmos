package ficha_01;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bom dia, vamos brincar aos supermercados!! :)");

        double preco1, preco2, preco3, total, desconto;

        System.out.print("Introduza o preço das batatas: ");
        preco1 = input.nextDouble();

        System.out.print("Introduza o preço dos iogurtes: ");
        preco2 = input.nextDouble();

        System.out.print("Introduza o preço das meias: ");
        preco3 = input.nextDouble();

        System.out.println("O preço dos items são : " + "Batatas : " + preco1 + " iogurtes : " + preco2 + " meias : " + preco3);

        total = preco1 + preco2 + preco3;
        System.out.print("Introduza o desconto pretendido: ");

        desconto = input.nextDouble()/100;

        total = total - (total * desconto);

        System.out.println("O preço total com desconto é: " + total);
    }
}
