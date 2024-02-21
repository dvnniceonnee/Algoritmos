package ficha_02;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);

        int escolhaUtilizador;

        System.out.println("Vamos dar uma vista de olhos no seu prémio");
        System.out.print("Qual foi o seu lugar na corrida ?");
        escolhaUtilizador = input.nextInt();

        switch (escolhaUtilizador){
            case 1 :
                System.out.println("1º Lugar ganhou 10 pontos!");
                break;
            case 2 :
                System.out.println("2º Lugar ganhou 8 pontos!");
                break;
            case 3 :
                System.out.println("3º Lugar ganhou 6 pontos!");
                break;
            case 4 :
                System.out.println("4º Lugar ganhou 5 pontos!");
                break;
            case 5 :
                System.out.println("5º Lugar ganhou 4 pontos!");
                break;
            case 6:
                System.out.println("6º Lugar ganhou 3 pontos!");
                break;
            case 7 :
                System.out.println("7º Lugar ganhou 2 pontos!");
                break;
            case 8 :
                System.out.println("8º Lugar ganhou 1 ponto");
                break;
            default:
                System.out.println("Não ganhou pontos :(");
        }
    }
}
