package extraFuncoes;

import java.util.Scanner;

public class exercicio_03 {
    public static double areaCalculo (double comprimento, double largura)
    {
        double area;
        area = comprimento * largura;
        return area;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de areas! >>>>>\n");

        System.out.print("Introduza a base : ");
        double base = input.nextDouble();
        System.out.print("Introduza a altura : ");
        double altura = input.nextDouble();;

        System.out.println("A area é : " + areaCalculo(base, altura));
        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}

