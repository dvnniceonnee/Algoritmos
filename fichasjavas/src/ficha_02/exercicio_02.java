package ficha_02;

import java.util.Scanner;

public class exercicio_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double salarioAnual, impostoSalarioAnual;

        System.out.print("Bom dia, qual é o seu salário anual : ");
        salarioAnual = input.nextDouble();

        if (salarioAnual <= 15000) {
            impostoSalarioAnual = salarioAnual * 0.20;
            System.out.print("Vai pagar 20% de taxa no total de : " + impostoSalarioAnual);
        }
        else {
            impostoSalarioAnual = salarioAnual * 0.30;
            System.out.print("Vai pagar 30% de taxa no total de : " + impostoSalarioAnual);
        }

    }
}
