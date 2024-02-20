package ficha_02;

import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double salarioAnualTotal, impostoSalario;

        System.out.println("Bom dia, vamos ver os seus impostos :)");
        System.out.println("Introduza o seu salário anual");
        salarioAnualTotal =  input.nextDouble();

        if (salarioAnualTotal <= 15000) {
            impostoSalario = salarioAnualTotal * 0.2;
            System.out.print("Vai pagar a 20% de taxa um total de " + impostoSalario);
        }
        else{
            if(salarioAnualTotal >15000 && salarioAnualTotal <= 20000) {
                impostoSalario = salarioAnualTotal * 0.3;
                System.out.print("Vai pagar a 30% de taxa um total " + impostoSalario);
            }
            else {
                if (salarioAnualTotal > 20000 && salarioAnualTotal <= 25000) {
                    impostoSalario = salarioAnualTotal * 0.35;
                    System.out.print("Vai pagar a 35% de taxa um total de " + impostoSalario);
                }
                else {
                    impostoSalario = salarioAnualTotal * 0.4;
                    System.out.print("Vai pagar a taxa de 40% um total de " + impostoSalario);
                }
            }
        }
    }
}
